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
bipush 0
istore_0
L3:
iload_0
bipush 10
if_icmple L2
goto L1
L2:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
iload_0
bipush 1
iadd
istore_0
goto L3
L1:
return
.end method
