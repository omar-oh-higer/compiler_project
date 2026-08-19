// Generated from grammar/TplParser.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT_OPEN=1, STYLE_TAG_OPEN=2, LT=3, JOPEN_EXPR=4, JOPEN_STMT=5, TEXT=6, 
		COMMENT_CLOSE=7, COMMENT_TEXT=8, GT=9, SLASH=10, EQUALS=11, DQUOTE=12, 
		BANG=13, DOCTYPE_KW=14, VOID_TAG_NAME=15, TAG_NAME=16, TAG_WS=17, DQUOTE_END=18, 
		ATTR_TEXT=19, JCLOSE_EXPR=20, JCLOSE_STMT=21, IF=22, ELIF=23, ELSE=24, 
		ENDIF=25, FOR=26, ENDFOR=27, IN=28, NOT=29, AND=30, OR=31, TRUE=32, FALSE=33, 
		NONE=34, CMP_EQ=35, CMP_NEQ=36, CMP_LE=37, CMP_GE=38, CMP_LT=39, CMP_GT=40, 
		DOT=41, PIPE=42, LPAREN=43, RPAREN=44, COMMA=45, NUMBER=46, STRING=47, 
		IDENT=48, JINJA_WS=49, STYLE_TAG_CLOSE=50, LBRACE=51, RBRACE=52, COLON=53, 
		SEMI=54, CSS_DOT=55, COLOR=56, UNIT=57, CSS_NUMBER=58, CSS_STRING=59, 
		CSS_IDENT=60, CSS_WS=61;
	public static final int
		RULE_document = 0, RULE_node = 1, RULE_doctype = 2, RULE_htmlComment = 3, 
		RULE_htmlElement = 4, RULE_htmlVoidElement = 5, RULE_attribute = 6, RULE_attrValue = 7, 
		RULE_styleElement = 8, RULE_stylesheet = 9, RULE_cssRule = 10, RULE_cssSelector = 11, 
		RULE_cssProperty = 12, RULE_cssValue = 13, RULE_cssValueItem = 14, RULE_jinjaExprTag = 15, 
		RULE_jFilter = 16, RULE_jFilterArgs = 17, RULE_jinjaIfStmt = 18, RULE_jinjaForStmt = 19, 
		RULE_jinjaExpr = 20, RULE_jOr = 21, RULE_jAnd = 22, RULE_jNot = 23, RULE_jComparison = 24, 
		RULE_compOp = 25, RULE_jAtomPath = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "node", "doctype", "htmlComment", "htmlElement", "htmlVoidElement", 
			"attribute", "attrValue", "styleElement", "stylesheet", "cssRule", "cssSelector", 
			"cssProperty", "cssValue", "cssValueItem", "jinjaExprTag", "jFilter", 
			"jFilterArgs", "jinjaIfStmt", "jinjaForStmt", "jinjaExpr", "jOr", "jAnd", 
			"jNot", "jComparison", "compOp", "jAtomPath"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<!--'", "'<style>'", null, "'{{'", "'{%'", null, "'-->'", null, 
			null, "'/'", "'='", null, "'!'", null, null, null, null, null, null, 
			"'}}'", "'%}'", "'if'", "'elif'", "'else'", "'endif'", "'for'", "'endfor'", 
			"'in'", "'not'", "'and'", "'or'", "'True'", "'False'", "'None'", "'=='", 
			"'!='", "'<='", "'>='", null, null, null, "'|'", "'('", "')'", "','", 
			null, null, null, null, "'</style>'", "'{'", "'}'", "':'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT_OPEN", "STYLE_TAG_OPEN", "LT", "JOPEN_EXPR", "JOPEN_STMT", 
			"TEXT", "COMMENT_CLOSE", "COMMENT_TEXT", "GT", "SLASH", "EQUALS", "DQUOTE", 
			"BANG", "DOCTYPE_KW", "VOID_TAG_NAME", "TAG_NAME", "TAG_WS", "DQUOTE_END", 
			"ATTR_TEXT", "JCLOSE_EXPR", "JCLOSE_STMT", "IF", "ELIF", "ELSE", "ENDIF", 
			"FOR", "ENDFOR", "IN", "NOT", "AND", "OR", "TRUE", "FALSE", "NONE", "CMP_EQ", 
			"CMP_NEQ", "CMP_LE", "CMP_GE", "CMP_LT", "CMP_GT", "DOT", "PIPE", "LPAREN", 
			"RPAREN", "COMMA", "NUMBER", "STRING", "IDENT", "JINJA_WS", "STYLE_TAG_CLOSE", 
			"LBRACE", "RBRACE", "COLON", "SEMI", "CSS_DOT", "COLOR", "UNIT", "CSS_NUMBER", 
			"CSS_STRING", "CSS_IDENT", "CSS_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TplParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TplParser.EOF, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 126L) != 0)) {
				{
				{
				setState(54);
				node();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NodeContext extends ParserRuleContext {
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
	 
		public NodeContext() { }
		public void copyFrom(NodeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNodeContext extends NodeContext {
		public JinjaExprTagContext jinjaExprTag() {
			return getRuleContext(JinjaExprTagContext.class,0);
		}
		public ExprNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterExprNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitExprNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitExprNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForNodeContext extends NodeContext {
		public JinjaForStmtContext jinjaForStmt() {
			return getRuleContext(JinjaForStmtContext.class,0);
		}
		public ForNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterForNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitForNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitForNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommentNodeContext extends NodeContext {
		public HtmlCommentContext htmlComment() {
			return getRuleContext(HtmlCommentContext.class,0);
		}
		public CommentNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCommentNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCommentNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCommentNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleNodeContext extends NodeContext {
		public StyleElementContext styleElement() {
			return getRuleContext(StyleElementContext.class,0);
		}
		public StyleNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterStyleNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitStyleNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitStyleNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextNodeContext extends NodeContext {
		public TerminalNode TEXT() { return getToken(TplParser.TEXT, 0); }
		public TextNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterTextNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitTextNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitTextNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfNodeContext extends NodeContext {
		public JinjaIfStmtContext jinjaIfStmt() {
			return getRuleContext(JinjaIfStmtContext.class,0);
		}
		public IfNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterIfNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitIfNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitIfNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementNodeContext extends NodeContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public ElementNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterElementNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitElementNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitElementNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementNodeContext extends NodeContext {
		public HtmlVoidElementContext htmlVoidElement() {
			return getRuleContext(HtmlVoidElementContext.class,0);
		}
		public VoidElementNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterVoidElementNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitVoidElementNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitVoidElementNode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoctypeNodeContext extends NodeContext {
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public DoctypeNodeContext(NodeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterDoctypeNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitDoctypeNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitDoctypeNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_node);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DoctypeNodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				doctype();
				}
				break;
			case 2:
				_localctx = new CommentNodeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				htmlComment();
				}
				break;
			case 3:
				_localctx = new VoidElementNodeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				htmlVoidElement();
				}
				break;
			case 4:
				_localctx = new ElementNodeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				htmlElement();
				}
				break;
			case 5:
				_localctx = new StyleNodeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(66);
				styleElement();
				}
				break;
			case 6:
				_localctx = new IfNodeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(67);
				jinjaIfStmt();
				}
				break;
			case 7:
				_localctx = new ForNodeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(68);
				jinjaForStmt();
				}
				break;
			case 8:
				_localctx = new ExprNodeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(69);
				jinjaExprTag();
				}
				break;
			case 9:
				_localctx = new TextNodeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(70);
				match(TEXT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoctypeContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TplParser.LT, 0); }
		public TerminalNode BANG() { return getToken(TplParser.BANG, 0); }
		public TerminalNode DOCTYPE_KW() { return getToken(TplParser.DOCTYPE_KW, 0); }
		public TerminalNode TAG_NAME() { return getToken(TplParser.TAG_NAME, 0); }
		public TerminalNode GT() { return getToken(TplParser.GT, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterDoctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitDoctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitDoctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(LT);
			setState(74);
			match(BANG);
			setState(75);
			match(DOCTYPE_KW);
			setState(76);
			match(TAG_NAME);
			setState(77);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlCommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_OPEN() { return getToken(TplParser.COMMENT_OPEN, 0); }
		public TerminalNode COMMENT_CLOSE() { return getToken(TplParser.COMMENT_CLOSE, 0); }
		public List<TerminalNode> COMMENT_TEXT() { return getTokens(TplParser.COMMENT_TEXT); }
		public TerminalNode COMMENT_TEXT(int i) {
			return getToken(TplParser.COMMENT_TEXT, i);
		}
		public HtmlCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterHtmlComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitHtmlComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitHtmlComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlCommentContext htmlComment() throws RecognitionException {
		HtmlCommentContext _localctx = new HtmlCommentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(COMMENT_OPEN);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_TEXT) {
				{
				{
				setState(80);
				match(COMMENT_TEXT);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(COMMENT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public List<TerminalNode> LT() { return getTokens(TplParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(TplParser.LT, i);
		}
		public List<TerminalNode> TAG_NAME() { return getTokens(TplParser.TAG_NAME); }
		public TerminalNode TAG_NAME(int i) {
			return getToken(TplParser.TAG_NAME, i);
		}
		public List<TerminalNode> GT() { return getTokens(TplParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(TplParser.GT, i);
		}
		public TerminalNode SLASH() { return getToken(TplParser.SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(LT);
			setState(89);
			match(TAG_NAME);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(90);
				attribute();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(GT);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					node();
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(103);
			match(LT);
			setState(104);
			match(SLASH);
			setState(105);
			match(TAG_NAME);
			setState(106);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlVoidElementContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TplParser.LT, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(TplParser.VOID_TAG_NAME, 0); }
		public TerminalNode GT() { return getToken(TplParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode SLASH() { return getToken(TplParser.SLASH, 0); }
		public HtmlVoidElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlVoidElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterHtmlVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitHtmlVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitHtmlVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlVoidElementContext htmlVoidElement() throws RecognitionException {
		HtmlVoidElementContext _localctx = new HtmlVoidElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_htmlVoidElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(LT);
			setState(109);
			match(VOID_TAG_NAME);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(110);
				attribute();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SLASH) {
				{
				setState(116);
				match(SLASH);
				}
			}

			setState(119);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode TAG_NAME() { return getToken(TplParser.TAG_NAME, 0); }
		public TerminalNode EQUALS() { return getToken(TplParser.EQUALS, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TAG_NAME);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(122);
				match(EQUALS);
				setState(123);
				attrValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueContext extends ParserRuleContext {
		public TerminalNode DQUOTE() { return getToken(TplParser.DQUOTE, 0); }
		public TerminalNode DQUOTE_END() { return getToken(TplParser.DQUOTE_END, 0); }
		public List<TerminalNode> ATTR_TEXT() { return getTokens(TplParser.ATTR_TEXT); }
		public TerminalNode ATTR_TEXT(int i) {
			return getToken(TplParser.ATTR_TEXT, i);
		}
		public List<JinjaExprTagContext> jinjaExprTag() {
			return getRuleContexts(JinjaExprTagContext.class);
		}
		public JinjaExprTagContext jinjaExprTag(int i) {
			return getRuleContext(JinjaExprTagContext.class,i);
		}
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterAttrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitAttrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitAttrValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attrValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(DQUOTE);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JOPEN_EXPR || _la==ATTR_TEXT) {
				{
				setState(129);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ATTR_TEXT:
					{
					setState(127);
					match(ATTR_TEXT);
					}
					break;
				case JOPEN_EXPR:
					{
					setState(128);
					jinjaExprTag();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(DQUOTE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleElementContext extends ParserRuleContext {
		public TerminalNode STYLE_TAG_OPEN() { return getToken(TplParser.STYLE_TAG_OPEN, 0); }
		public TerminalNode STYLE_TAG_CLOSE() { return getToken(TplParser.STYLE_TAG_CLOSE, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public StyleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterStyleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitStyleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitStyleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleElementContext styleElement() throws RecognitionException {
		StyleElementContext _localctx = new StyleElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_styleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(STYLE_TAG_OPEN);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_DOT || _la==CSS_IDENT) {
				{
				{
				setState(137);
				cssRule();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(STYLE_TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StylesheetContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TplParser.EOF, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_DOT || _la==CSS_IDENT) {
				{
				{
				setState(145);
				cssRule();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssSelectorContext cssSelector() {
			return getRuleContext(CssSelectorContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(TplParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TplParser.RBRACE, 0); }
		public List<CssPropertyContext> cssProperty() {
			return getRuleContexts(CssPropertyContext.class);
		}
		public CssPropertyContext cssProperty(int i) {
			return getRuleContext(CssPropertyContext.class,i);
		}
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			cssSelector();
			setState(154);
			match(LBRACE);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_IDENT) {
				{
				{
				setState(155);
				cssProperty();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public List<TerminalNode> CSS_IDENT() { return getTokens(TplParser.CSS_IDENT); }
		public TerminalNode CSS_IDENT(int i) {
			return getToken(TplParser.CSS_IDENT, i);
		}
		public List<TerminalNode> CSS_DOT() { return getTokens(TplParser.CSS_DOT); }
		public TerminalNode CSS_DOT(int i) {
			return getToken(TplParser.CSS_DOT, i);
		}
		public TerminalNode COLON() { return getToken(TplParser.COLON, 0); }
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCssSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCssSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssSelector);
		int _la;
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(CSS_IDENT);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CSS_DOT) {
					{
					{
					setState(164);
					match(CSS_DOT);
					setState(165);
					match(CSS_IDENT);
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(171);
					match(COLON);
					setState(172);
					match(CSS_IDENT);
					}
				}

				}
				break;
			case CSS_DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(CSS_DOT);
				setState(176);
				match(CSS_IDENT);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(177);
					match(COLON);
					setState(178);
					match(CSS_IDENT);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssPropertyContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(TplParser.CSS_IDENT, 0); }
		public TerminalNode COLON() { return getToken(TplParser.COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TplParser.SEMI, 0); }
		public CssPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCssProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCssProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCssProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssPropertyContext cssProperty() throws RecognitionException {
		CssPropertyContext _localctx = new CssPropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(CSS_IDENT);
			setState(184);
			match(COLON);
			setState(185);
			cssValue();
			setState(186);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public List<CssValueItemContext> cssValueItem() {
			return getRuleContexts(CssValueItemContext.class);
		}
		public CssValueItemContext cssValueItem(int i) {
			return getRuleContext(CssValueItemContext.class,i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(188);
				cssValueItem();
				}
				}
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2089670227099910144L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueItemContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(TplParser.CSS_IDENT, 0); }
		public TerminalNode CSS_NUMBER() { return getToken(TplParser.CSS_NUMBER, 0); }
		public TerminalNode UNIT() { return getToken(TplParser.UNIT, 0); }
		public TerminalNode COLOR() { return getToken(TplParser.COLOR, 0); }
		public TerminalNode CSS_STRING() { return getToken(TplParser.CSS_STRING, 0); }
		public CssValueItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCssValueItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCssValueItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCssValueItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueItemContext cssValueItem() throws RecognitionException {
		CssValueItemContext _localctx = new CssValueItemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cssValueItem);
		int _la;
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(CSS_IDENT);
				}
				break;
			case CSS_NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(CSS_NUMBER);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNIT) {
					{
					setState(195);
					match(UNIT);
					}
				}

				}
				break;
			case COLOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				match(COLOR);
				}
				break;
			case CSS_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				match(CSS_STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprTagContext extends ParserRuleContext {
		public TerminalNode JOPEN_EXPR() { return getToken(TplParser.JOPEN_EXPR, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JCLOSE_EXPR() { return getToken(TplParser.JCLOSE_EXPR, 0); }
		public List<JFilterContext> jFilter() {
			return getRuleContexts(JFilterContext.class);
		}
		public JFilterContext jFilter(int i) {
			return getRuleContext(JFilterContext.class,i);
		}
		public JinjaExprTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExprTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJinjaExprTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJinjaExprTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJinjaExprTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprTagContext jinjaExprTag() throws RecognitionException {
		JinjaExprTagContext _localctx = new JinjaExprTagContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jinjaExprTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(JOPEN_EXPR);
			setState(203);
			jinjaExpr();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PIPE) {
				{
				{
				setState(204);
				jFilter();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(JCLOSE_EXPR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JFilterContext extends ParserRuleContext {
		public TerminalNode PIPE() { return getToken(TplParser.PIPE, 0); }
		public TerminalNode IDENT() { return getToken(TplParser.IDENT, 0); }
		public TerminalNode LPAREN() { return getToken(TplParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TplParser.RPAREN, 0); }
		public JFilterArgsContext jFilterArgs() {
			return getRuleContext(JFilterArgsContext.class,0);
		}
		public JFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JFilterContext jFilter() throws RecognitionException {
		JFilterContext _localctx = new JFilterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jFilter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(PIPE);
			setState(213);
			match(IDENT);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(214);
				match(LPAREN);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 492611810885632L) != 0)) {
					{
					setState(215);
					jFilterArgs();
					}
				}

				setState(218);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JFilterArgsContext extends ParserRuleContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TplParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TplParser.COMMA, i);
		}
		public JFilterArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jFilterArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJFilterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJFilterArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJFilterArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JFilterArgsContext jFilterArgs() throws RecognitionException {
		JFilterArgsContext _localctx = new JFilterArgsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jFilterArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			jinjaExpr();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(222);
				match(COMMA);
				setState(223);
				jinjaExpr();
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfStmtContext extends ParserRuleContext {
		public List<TerminalNode> JOPEN_STMT() { return getTokens(TplParser.JOPEN_STMT); }
		public TerminalNode JOPEN_STMT(int i) {
			return getToken(TplParser.JOPEN_STMT, i);
		}
		public TerminalNode IF() { return getToken(TplParser.IF, 0); }
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public List<TerminalNode> JCLOSE_STMT() { return getTokens(TplParser.JCLOSE_STMT); }
		public TerminalNode JCLOSE_STMT(int i) {
			return getToken(TplParser.JCLOSE_STMT, i);
		}
		public TerminalNode ENDIF() { return getToken(TplParser.ENDIF, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(TplParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(TplParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(TplParser.ELSE, 0); }
		public JinjaIfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIfStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJinjaIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJinjaIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJinjaIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfStmtContext jinjaIfStmt() throws RecognitionException {
		JinjaIfStmtContext _localctx = new JinjaIfStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jinjaIfStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(JOPEN_STMT);
			setState(230);
			match(IF);
			setState(231);
			jinjaExpr();
			setState(232);
			match(JCLOSE_STMT);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					node();
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(239);
					match(JOPEN_STMT);
					setState(240);
					match(ELIF);
					setState(241);
					jinjaExpr();
					setState(242);
					match(JCLOSE_STMT);
					setState(246);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(243);
							node();
							}
							} 
						}
						setState(248);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					}
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(254);
				match(JOPEN_STMT);
				setState(255);
				match(ELSE);
				setState(256);
				match(JCLOSE_STMT);
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(257);
						node();
						}
						} 
					}
					setState(262);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			}
			setState(265);
			match(JOPEN_STMT);
			setState(266);
			match(ENDIF);
			setState(267);
			match(JCLOSE_STMT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForStmtContext extends ParserRuleContext {
		public List<TerminalNode> JOPEN_STMT() { return getTokens(TplParser.JOPEN_STMT); }
		public TerminalNode JOPEN_STMT(int i) {
			return getToken(TplParser.JOPEN_STMT, i);
		}
		public TerminalNode FOR() { return getToken(TplParser.FOR, 0); }
		public TerminalNode IDENT() { return getToken(TplParser.IDENT, 0); }
		public TerminalNode IN() { return getToken(TplParser.IN, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public List<TerminalNode> JCLOSE_STMT() { return getTokens(TplParser.JCLOSE_STMT); }
		public TerminalNode JCLOSE_STMT(int i) {
			return getToken(TplParser.JCLOSE_STMT, i);
		}
		public TerminalNode ENDFOR() { return getToken(TplParser.ENDFOR, 0); }
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TplParser.ELSE, 0); }
		public JinjaForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJinjaForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJinjaForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJinjaForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForStmtContext jinjaForStmt() throws RecognitionException {
		JinjaForStmtContext _localctx = new JinjaForStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_jinjaForStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(JOPEN_STMT);
			setState(270);
			match(FOR);
			setState(271);
			match(IDENT);
			setState(272);
			match(IN);
			setState(273);
			jinjaExpr();
			setState(274);
			match(JCLOSE_STMT);
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(275);
					node();
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(281);
				match(JOPEN_STMT);
				setState(282);
				match(ELSE);
				setState(283);
				match(JCLOSE_STMT);
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(284);
						node();
						}
						} 
					}
					setState(289);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			}
			setState(292);
			match(JOPEN_STMT);
			setState(293);
			match(ENDFOR);
			setState(294);
			match(JCLOSE_STMT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends ParserRuleContext {
		public JOrContext jOr() {
			return getRuleContext(JOrContext.class,0);
		}
		public JinjaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContext jinjaExpr() throws RecognitionException {
		JinjaExprContext _localctx = new JinjaExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_jinjaExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			jOr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JOrContext extends ParserRuleContext {
		public List<JAndContext> jAnd() {
			return getRuleContexts(JAndContext.class);
		}
		public JAndContext jAnd(int i) {
			return getRuleContext(JAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TplParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TplParser.OR, i);
		}
		public JOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JOrContext jOr() throws RecognitionException {
		JOrContext _localctx = new JOrContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_jOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			jAnd();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(299);
				match(OR);
				setState(300);
				jAnd();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JAndContext extends ParserRuleContext {
		public List<JNotContext> jNot() {
			return getRuleContexts(JNotContext.class);
		}
		public JNotContext jNot(int i) {
			return getRuleContext(JNotContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TplParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TplParser.AND, i);
		}
		public JAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JAndContext jAnd() throws RecognitionException {
		JAndContext _localctx = new JAndContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_jAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			jNot();
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(307);
				match(AND);
				setState(308);
				jNot();
				}
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JNotContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(TplParser.NOT, 0); }
		public JNotContext jNot() {
			return getRuleContext(JNotContext.class,0);
		}
		public JComparisonContext jComparison() {
			return getRuleContext(JComparisonContext.class,0);
		}
		public JNotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jNot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JNotContext jNot() throws RecognitionException {
		JNotContext _localctx = new JNotContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jNot);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(NOT);
				setState(315);
				jNot();
				}
				break;
			case TRUE:
			case FALSE:
			case NONE:
			case NUMBER:
			case STRING:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				jComparison();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JComparisonContext extends ParserRuleContext {
		public List<JAtomPathContext> jAtomPath() {
			return getRuleContexts(JAtomPathContext.class);
		}
		public JAtomPathContext jAtomPath(int i) {
			return getRuleContext(JAtomPathContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public JComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jComparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterJComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitJComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitJComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JComparisonContext jComparison() throws RecognitionException {
		JComparisonContext _localctx = new JComparisonContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_jComparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			jAtomPath();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) {
				{
				setState(320);
				compOp();
				setState(321);
				jAtomPath();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode CMP_EQ() { return getToken(TplParser.CMP_EQ, 0); }
		public TerminalNode CMP_NEQ() { return getToken(TplParser.CMP_NEQ, 0); }
		public TerminalNode CMP_LT() { return getToken(TplParser.CMP_LT, 0); }
		public TerminalNode CMP_GT() { return getToken(TplParser.CMP_GT, 0); }
		public TerminalNode CMP_LE() { return getToken(TplParser.CMP_LE, 0); }
		public TerminalNode CMP_GE() { return getToken(TplParser.CMP_GE, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2164663517184L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JAtomPathContext extends ParserRuleContext {
		public JAtomPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jAtomPath; }
	 
		public JAtomPathContext() { }
		public void copyFrom(JAtomPathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueAtomContext extends JAtomPathContext {
		public TerminalNode TRUE() { return getToken(TplParser.TRUE, 0); }
		public TrueAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterTrueAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitTrueAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitTrueAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseAtomContext extends JAtomPathContext {
		public TerminalNode FALSE() { return getToken(TplParser.FALSE, 0); }
		public FalseAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterFalseAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitFalseAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitFalseAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PathAtomContext extends JAtomPathContext {
		public List<TerminalNode> IDENT() { return getTokens(TplParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(TplParser.IDENT, i);
		}
		public List<TerminalNode> DOT() { return getTokens(TplParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(TplParser.DOT, i);
		}
		public PathAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterPathAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitPathAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitPathAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberAtomContext extends JAtomPathContext {
		public TerminalNode NUMBER() { return getToken(TplParser.NUMBER, 0); }
		public NumberAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterNumberAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitNumberAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitNumberAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringAtomContext extends JAtomPathContext {
		public TerminalNode STRING() { return getToken(TplParser.STRING, 0); }
		public StringAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterStringAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitStringAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitStringAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneAtomContext extends JAtomPathContext {
		public TerminalNode NONE() { return getToken(TplParser.NONE, 0); }
		public NoneAtomContext(JAtomPathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).enterNoneAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TplParserListener ) ((TplParserListener)listener).exitNoneAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TplParserVisitor ) return ((TplParserVisitor<? extends T>)visitor).visitNoneAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JAtomPathContext jAtomPath() throws RecognitionException {
		JAtomPathContext _localctx = new JAtomPathContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_jAtomPath);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				_localctx = new PathAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(IDENT);
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(328);
					match(DOT);
					setState(329);
					match(IDENT);
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NUMBER:
				_localctx = new NumberAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				match(STRING);
				}
				break;
			case TRUE:
				_localctx = new TrueAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseAtomContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				match(FALSE);
				}
				break;
			case NONE:
				_localctx = new NoneAtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(339);
				match(NONE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u0157\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0005\u0000"+
		"8\b\u0000\n\u0000\f\u0000;\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001H\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0005\u0003R\b\u0003\n\u0003\f\u0003U\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\\\b\u0004\n\u0004\f\u0004"+
		"_\t\u0004\u0001\u0004\u0001\u0004\u0005\u0004c\b\u0004\n\u0004\f\u0004"+
		"f\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005p\b\u0005\n\u0005\f\u0005"+
		"s\t\u0005\u0001\u0005\u0003\u0005v\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006}\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0082\b\u0007\n\u0007\f\u0007\u0085\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u008b\b\b\n\b\f\b\u008e"+
		"\t\b\u0001\b\u0001\b\u0001\t\u0005\t\u0093\b\t\n\t\f\t\u0096\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u009d\b\n\n\n\f\n\u00a0\t\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a7"+
		"\b\u000b\n\u000b\f\u000b\u00aa\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00ae\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00b4\b\u000b\u0003\u000b\u00b6\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0004\r\u00be\b\r\u000b\r\f\r\u00bf\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00c5\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00c9\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ce"+
		"\b\u000f\n\u000f\f\u000f\u00d1\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00d9\b\u0010\u0001\u0010"+
		"\u0003\u0010\u00dc\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00e1\b\u0011\n\u0011\f\u0011\u00e4\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00eb\b\u0012\n\u0012\f\u0012"+
		"\u00ee\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u00f5\b\u0012\n\u0012\f\u0012\u00f8\t\u0012\u0005\u0012\u00fa"+
		"\b\u0012\n\u0012\f\u0012\u00fd\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u0103\b\u0012\n\u0012\f\u0012\u0106\t\u0012\u0003"+
		"\u0012\u0108\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u0115\b\u0013\n\u0013\f\u0013\u0118\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u011e\b\u0013\n\u0013"+
		"\f\u0013\u0121\t\u0013\u0003\u0013\u0123\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u012e\b\u0015\n\u0015\f\u0015\u0131\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u0136\b\u0016\n\u0016\f\u0016"+
		"\u0139\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u013e\b"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0144"+
		"\b\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u014b\b\u001a\n\u001a\f\u001a\u014e\t\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0155\b\u001a\u0001\u001a"+
		"\u0000\u0000\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0001\u0001\u0000#(\u016e"+
		"\u00009\u0001\u0000\u0000\u0000\u0002G\u0001\u0000\u0000\u0000\u0004I"+
		"\u0001\u0000\u0000\u0000\u0006O\u0001\u0000\u0000\u0000\bX\u0001\u0000"+
		"\u0000\u0000\nl\u0001\u0000\u0000\u0000\fy\u0001\u0000\u0000\u0000\u000e"+
		"~\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000\u0000\u0000\u0012\u0094"+
		"\u0001\u0000\u0000\u0000\u0014\u0099\u0001\u0000\u0000\u0000\u0016\u00b5"+
		"\u0001\u0000\u0000\u0000\u0018\u00b7\u0001\u0000\u0000\u0000\u001a\u00bd"+
		"\u0001\u0000\u0000\u0000\u001c\u00c8\u0001\u0000\u0000\u0000\u001e\u00ca"+
		"\u0001\u0000\u0000\u0000 \u00d4\u0001\u0000\u0000\u0000\"\u00dd\u0001"+
		"\u0000\u0000\u0000$\u00e5\u0001\u0000\u0000\u0000&\u010d\u0001\u0000\u0000"+
		"\u0000(\u0128\u0001\u0000\u0000\u0000*\u012a\u0001\u0000\u0000\u0000,"+
		"\u0132\u0001\u0000\u0000\u0000.\u013d\u0001\u0000\u0000\u00000\u013f\u0001"+
		"\u0000\u0000\u00002\u0145\u0001\u0000\u0000\u00004\u0154\u0001\u0000\u0000"+
		"\u000068\u0003\u0002\u0001\u000076\u0001\u0000\u0000\u00008;\u0001\u0000"+
		"\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\u0000\u0000\u0001"+
		"=\u0001\u0001\u0000\u0000\u0000>H\u0003\u0004\u0002\u0000?H\u0003\u0006"+
		"\u0003\u0000@H\u0003\n\u0005\u0000AH\u0003\b\u0004\u0000BH\u0003\u0010"+
		"\b\u0000CH\u0003$\u0012\u0000DH\u0003&\u0013\u0000EH\u0003\u001e\u000f"+
		"\u0000FH\u0005\u0006\u0000\u0000G>\u0001\u0000\u0000\u0000G?\u0001\u0000"+
		"\u0000\u0000G@\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GB\u0001"+
		"\u0000\u0000\u0000GC\u0001\u0000\u0000\u0000GD\u0001\u0000\u0000\u0000"+
		"GE\u0001\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u0003\u0001\u0000"+
		"\u0000\u0000IJ\u0005\u0003\u0000\u0000JK\u0005\r\u0000\u0000KL\u0005\u000e"+
		"\u0000\u0000LM\u0005\u0010\u0000\u0000MN\u0005\t\u0000\u0000N\u0005\u0001"+
		"\u0000\u0000\u0000OS\u0005\u0001\u0000\u0000PR\u0005\b\u0000\u0000QP\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000VW\u0005\u0007\u0000\u0000W\u0007\u0001\u0000\u0000\u0000XY\u0005"+
		"\u0003\u0000\u0000Y]\u0005\u0010\u0000\u0000Z\\\u0003\f\u0006\u0000[Z"+
		"\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000"+
		"\u0000\u0000`d\u0005\t\u0000\u0000ac\u0003\u0002\u0001\u0000ba\u0001\u0000"+
		"\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"gh\u0005\u0003\u0000\u0000hi\u0005\n\u0000\u0000ij\u0005\u0010\u0000\u0000"+
		"jk\u0005\t\u0000\u0000k\t\u0001\u0000\u0000\u0000lm\u0005\u0003\u0000"+
		"\u0000mq\u0005\u000f\u0000\u0000np\u0003\f\u0006\u0000on\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0005"+
		"\n\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wx\u0005\t\u0000\u0000x\u000b\u0001\u0000\u0000\u0000"+
		"y|\u0005\u0010\u0000\u0000z{\u0005\u000b\u0000\u0000{}\u0003\u000e\u0007"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\r\u0001\u0000"+
		"\u0000\u0000~\u0083\u0005\f\u0000\u0000\u007f\u0082\u0005\u0013\u0000"+
		"\u0000\u0080\u0082\u0003\u001e\u000f\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0005\u0012\u0000\u0000\u0087\u000f\u0001\u0000\u0000"+
		"\u0000\u0088\u008c\u0005\u0002\u0000\u0000\u0089\u008b\u0003\u0014\n\u0000"+
		"\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000"+
		"\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u00052\u0000\u0000\u0090\u0011\u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0003\u0014\n\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0096"+
		"\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0094"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0000\u0000\u0001\u0098\u0013"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0003\u0016\u000b\u0000\u009a\u009e"+
		"\u00053\u0000\u0000\u009b\u009d\u0003\u0018\f\u0000\u009c\u009b\u0001"+
		"\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"4\u0000\u0000\u00a2\u0015\u0001\u0000\u0000\u0000\u00a3\u00a8\u0005<\u0000"+
		"\u0000\u00a4\u00a5\u00057\u0000\u0000\u00a5\u00a7\u0005<\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ad\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u00055\u0000\u0000\u00ac\u00ae\u0005<\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b6\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u00057\u0000\u0000\u00b0\u00b3\u0005<\u0000"+
		"\u0000\u00b1\u00b2\u00055\u0000\u0000\u00b2\u00b4\u0005<\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b5\u00a3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00af\u0001\u0000\u0000\u0000\u00b6\u0017\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005<\u0000\u0000\u00b8\u00b9\u00055\u0000\u0000\u00b9\u00ba\u0003"+
		"\u001a\r\u0000\u00ba\u00bb\u00056\u0000\u0000\u00bb\u0019\u0001\u0000"+
		"\u0000\u0000\u00bc\u00be\u0003\u001c\u000e\u0000\u00bd\u00bc\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u001b\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c9\u0005<\u0000\u0000\u00c2\u00c4\u0005:\u0000\u0000"+
		"\u00c3\u00c5\u00059\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c9\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c9\u00058\u0000\u0000\u00c7\u00c9\u0005;\u0000\u0000\u00c8\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c2\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u001d\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005\u0004\u0000\u0000\u00cb\u00cf\u0003"+
		"(\u0014\u0000\u00cc\u00ce\u0003 \u0010\u0000\u00cd\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0014\u0000"+
		"\u0000\u00d3\u001f\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005*\u0000\u0000"+
		"\u00d5\u00db\u00050\u0000\u0000\u00d6\u00d8\u0005+\u0000\u0000\u00d7\u00d9"+
		"\u0003\"\u0011\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dc\u0005"+
		",\u0000\u0000\u00db\u00d6\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc!\u0001\u0000\u0000\u0000\u00dd\u00e2\u0003(\u0014\u0000"+
		"\u00de\u00df\u0005-\u0000\u0000\u00df\u00e1\u0003(\u0014\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3#\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005"+
		"\u0005\u0000\u0000\u00e6\u00e7\u0005\u0016\u0000\u0000\u00e7\u00e8\u0003"+
		"(\u0014\u0000\u00e8\u00ec\u0005\u0015\u0000\u0000\u00e9\u00eb\u0003\u0002"+
		"\u0001\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ed\u00fb\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ef\u00f0\u0005\u0005\u0000\u0000\u00f0\u00f1\u0005\u0017"+
		"\u0000\u0000\u00f1\u00f2\u0003(\u0014\u0000\u00f2\u00f6\u0005\u0015\u0000"+
		"\u0000\u00f3\u00f5\u0003\u0002\u0001\u0000\u00f4\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00ef\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0107\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u0005\u0000"+
		"\u0000\u00ff\u0100\u0005\u0018\u0000\u0000\u0100\u0104\u0005\u0015\u0000"+
		"\u0000\u0101\u0103\u0003\u0002\u0001\u0000\u0102\u0101\u0001\u0000\u0000"+
		"\u0000\u0103\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0108\u0001\u0000\u0000"+
		"\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0107\u00fe\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000"+
		"\u0000\u0109\u010a\u0005\u0005\u0000\u0000\u010a\u010b\u0005\u0019\u0000"+
		"\u0000\u010b\u010c\u0005\u0015\u0000\u0000\u010c%\u0001\u0000\u0000\u0000"+
		"\u010d\u010e\u0005\u0005\u0000\u0000\u010e\u010f\u0005\u001a\u0000\u0000"+
		"\u010f\u0110\u00050\u0000\u0000\u0110\u0111\u0005\u001c\u0000\u0000\u0111"+
		"\u0112\u0003(\u0014\u0000\u0112\u0116\u0005\u0015\u0000\u0000\u0113\u0115"+
		"\u0003\u0002\u0001\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118"+
		"\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0001\u0000\u0000\u0000\u0117\u0122\u0001\u0000\u0000\u0000\u0118\u0116"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0005\u0005\u0000\u0000\u011a\u011b"+
		"\u0005\u0018\u0000\u0000\u011b\u011f\u0005\u0015\u0000\u0000\u011c\u011e"+
		"\u0003\u0002\u0001\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011e\u0121"+
		"\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0001\u0000\u0000\u0000\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f"+
		"\u0001\u0000\u0000\u0000\u0122\u0119\u0001\u0000\u0000\u0000\u0122\u0123"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0005\u0005\u0000\u0000\u0125\u0126\u0005\u001b\u0000\u0000\u0126\u0127"+
		"\u0005\u0015\u0000\u0000\u0127\'\u0001\u0000\u0000\u0000\u0128\u0129\u0003"+
		"*\u0015\u0000\u0129)\u0001\u0000\u0000\u0000\u012a\u012f\u0003,\u0016"+
		"\u0000\u012b\u012c\u0005\u001f\u0000\u0000\u012c\u012e\u0003,\u0016\u0000"+
		"\u012d\u012b\u0001\u0000\u0000\u0000\u012e\u0131\u0001\u0000\u0000\u0000"+
		"\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000"+
		"\u0130+\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132"+
		"\u0137\u0003.\u0017\u0000\u0133\u0134\u0005\u001e\u0000\u0000\u0134\u0136"+
		"\u0003.\u0017\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0139\u0001"+
		"\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0137\u0138\u0001"+
		"\u0000\u0000\u0000\u0138-\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0005\u001d\u0000\u0000\u013b\u013e\u0003.\u0017"+
		"\u0000\u013c\u013e\u00030\u0018\u0000\u013d\u013a\u0001\u0000\u0000\u0000"+
		"\u013d\u013c\u0001\u0000\u0000\u0000\u013e/\u0001\u0000\u0000\u0000\u013f"+
		"\u0143\u00034\u001a\u0000\u0140\u0141\u00032\u0019\u0000\u0141\u0142\u0003"+
		"4\u001a\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0140\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u01441\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0007\u0000\u0000\u0000\u01463\u0001\u0000\u0000\u0000"+
		"\u0147\u014c\u00050\u0000\u0000\u0148\u0149\u0005)\u0000\u0000\u0149\u014b"+
		"\u00050\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001"+
		"\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u0155\u0001\u0000\u0000\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014f\u0155\u0005.\u0000\u0000\u0150\u0155\u0005/\u0000"+
		"\u0000\u0151\u0155\u0005 \u0000\u0000\u0152\u0155\u0005!\u0000\u0000\u0153"+
		"\u0155\u0005\"\u0000\u0000\u0154\u0147\u0001\u0000\u0000\u0000\u0154\u014f"+
		"\u0001\u0000\u0000\u0000\u0154\u0150\u0001\u0000\u0000\u0000\u0154\u0151"+
		"\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0153"+
		"\u0001\u0000\u0000\u0000\u01555\u0001\u0000\u0000\u0000&9GS]dqu|\u0081"+
		"\u0083\u008c\u0094\u009e\u00a8\u00ad\u00b3\u00b5\u00bf\u00c4\u00c8\u00cf"+
		"\u00d8\u00db\u00e2\u00ec\u00f6\u00fb\u0104\u0107\u0116\u011f\u0122\u012f"+
		"\u0137\u013d\u0143\u014c\u0154";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}