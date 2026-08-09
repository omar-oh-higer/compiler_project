parser grammar GreetParser;

options { tokenVocab = GreetLexer; }

greeting : GREETING NAME EOF ;
