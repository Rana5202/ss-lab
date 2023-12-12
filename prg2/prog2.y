
%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
int yyerror();
int count=0;
%}
%token A B
%%
s:A s{count++;}
|B
;
%%
int main()
{
int n;
printf("enter value for n\n");
scanf("%d",&n);
getchar();
printf("enter input string with a's and b's\n");
yyparse();
if(n==count)
printf("valid string\n");
else
yyerror();
return 0;
}
int yyerror()
{
printf("invalid string\n");
exit(0);
}