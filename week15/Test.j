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
bipush 7
istore_0
goto L2
L1:
iload_0
bipush 2
iadd
istore_0
goto L3
L2:
iload_0
bipush 3
iadd
istore_0
goto L3
L3:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
return
.end method
