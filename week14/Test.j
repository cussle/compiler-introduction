.class public Test
.super java/lang/Object
; standard initializer
.method public <init>()V
aload_0
invokenonvirtual java/lang/Object/<init>()V
return
.end method

.method public static add(II)I
.limit stack 32
.limit locals 32
iload_0
iload_1
iadd
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
bipush 0
istore_0
bipush 5
bipush 3
invokestatic Test/add(II)I

istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
return
.end method
