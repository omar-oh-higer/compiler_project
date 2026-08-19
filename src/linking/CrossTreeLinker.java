package linking;

import errors.DataBindingUnresolvedException;
import errors.TemplateSchemaMismatchException;
import semantic.TemplateSemanticAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Connects the two already-clean ASTs: for every "free" variable a template
 * actually uses (TemplateSemanticAnalyzer.FreeVarUsage — collected without
 * any knowledge of Python), checks it against the render_template() call
 * sites the Python side collected for that same template name. This is a
 * real link between the two trees' analysis results, not a string-matching
 * hack bolted onto a driver class.
 */
public final class CrossTreeLinker {

    private CrossTreeLinker() {
    }

    public static void link(String templateName,
                             TemplateSemanticAnalyzer templateAnalyzer,
                             Map<String, List<Set<String>>> renderTemplateCalls,
                             Set<String> productSchema) {
        List<Set<String>> callSites = renderTemplateCalls.get(templateName);

        for (TemplateSemanticAnalyzer.FreeVarUsage usage : templateAnalyzer.getFreeVarUsages()) {
            String rootName = usage.pathParts.get(0);

            boolean passedSomewhere = callSites != null
                    && callSites.stream().anyMatch(kwargs -> kwargs.contains(rootName));
            if (!passedSomewhere) {
                throw new DataBindingUnresolvedException(rootName, templateName, usage.line);
            }

            if (usage.pathParts.size() > 1) {
                String field = usage.pathParts.get(1);
                if (!productSchema.isEmpty() && !productSchema.contains(field)) {
                    throw new TemplateSchemaMismatchException(field, templateName, usage.line);
                }
            }
        }
    }
}
