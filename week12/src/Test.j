.class public Test
.super java/lang/Object
; standard initializer
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
bipush 10
istore_0
iconst_5
istore_1
iconst_0
istore_2
iconst_5
bipush 10
iadd
istore_1
iload_0
iload_0
iadd
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream/println(I)V
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_1
invokevirtual java/io/PrintStream/println(I)V
iconst_2
iconst_3
imul
iconst_4
imul
iconst_5
imul
iconst_1
iadd
bipush 6
iadd
bipush 7
bipush 8
imul
iadd
bipush 9
iadd
bipush 10
iadd
istore_2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_2
invokevirtual java/io/PrintStream/println(I)V
return
.end method
