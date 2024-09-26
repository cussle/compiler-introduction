grammar tinyR4;

program	    : decl+		{System.out.println("202200000 Rule 0");}   ;

decl		: 	fun_decl ;

fun_decl	: FUNC ID '(' params ')' ret_type_spec compound_stmt    ;

params		:
		| param (',' param)*
		;

param		:  ID ':' type_spec 		;

type_spec	:  U32				    ;     // how about including array or string?

ret_type_spec	:
		| RARROW type_spec
		;

compound_stmt: '{' local_decl* stmt* '}'	;

local_decl	: dec_spec ID  (':' type_spec)? ('=' val) ';' ;

dec_spec	: LET (MUT)?            ; 			// how about LET MUT ?

val 		: LITERAL | ID				;

stmt		: expr_stmt
		| compound_stmt
		| if_stmt
		| return_stmt
		;

expr_stmt	: expr 		';'		;

expr	:   additive_expr
	| relative_expr
	| ID '=' expr
	;

additive_expr: left=additive_expr op=('+'|'-') right=multiplicative_expr
        | multiplicative_expr
        ;

multiplicative_expr:  left=multiplicative_expr op=('*'|'/'|'%') right=unary_expr
        |unary_expr
        ;

unary_expr: op=('-'|'+'|'--'|'++'|'!') expr
        | factor
        ;

factor : (LITERAL|ID)
         	| '(' expr ')'
         	| ID '!'? '(' args ')'
         ;

relative_expr: left=relative_expr op=(AND|OR) right=comparative_expr
         	 | comparative_expr
         	 ;

comparative_expr : left=comparative_expr op=(EQ|NE|LE|'<'|GE|'>') right=additive_expr
            | additive_expr
            ;

if_stmt		:  IF  relative_expr  stmt (ELSE stmt)? 		;

return_stmt	: RETURN (expr)? ';'            ;

args	:
       | expr (',' expr)*                   ;
// 22-2 가 마지막, 총 39개?
FUNC: 'fn';
U32: 'u32';

IF: 'if';
ELSE: 'else';
RETURN: 'return';
LET: 'let';
MUT: 'mut';

OR: '||';
AND: '&&';
LE: '<=';
GE: '>=';
EQ: '==';
NE: '!=';
RARROW: '->';

ID  : [a-zA-Z_] [_a-zA-Z0-9]*;

LITERAL:  LIT_INT | LIT_STR;

LIT_INT: DecimalConstant     |   OctalConstant     |   HexadecimalConstant
        | NilConstant | WildCardConstant   ;

LIT_STR : '"' .*? '"' ;

DecimalConstant
    :   '0'
	|   [1-9] [0-9]*
    ;

OctalConstant
    :   '0'[0-7]*
    ;

HexadecimalConstant
    :   '0' [xX] [0-9a-fA-F] +
    ;

NilConstant
	: 'NIL'
	| 'nil'
	;

WildCardConstant
	: '_'
	;

WS  :   (   ' '
        |   '\t'
        |   '\r'
        |   '\n'
        )+
	-> channel(HIDDEN)
    ;