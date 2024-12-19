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

.method public static sub(II)I
.limit stack 32
.limit locals 32
iload_0
iload_1
isub
ireturn
.end method

.method public static mul(III)I
.limit stack 32
.limit locals 32
iload_0
iload_1
imul
iload_2
imul
ireturn
.end method

.method public static div(II)I
.limit stack 32
.limit locals 32
iload_0
iload_1
idiv
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 32
.limit locals 32
bipush 0
istore_0
bipush 10
istore_1
bipush 2
istore_2
bipush 5
bipush 3
invokestatic Test/add(II)I
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
iload_1
iload_0
invokestatic Test/sub(II)I
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
iload_0
iload_1
iload_2
invokestatic Test/mul(III)I
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
bipush 0
istore_0
L4:
iload_0
bipush 10
if_icmpgt L2
iload_0
bipush 1
iadd
istore_0
goto L3
L2:
goto L1
L3:
goto L4
L1:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
bipush 0
istore_0
bipush 1
istore_3
L6:
iload_3
bipush 11
if_icmpge L5
iload_0
iload_3
iadd
istore_0
iload_3
bipush 1
iadd
istore_3
goto L6
L5:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
bipush 5
bipush 3
invokestatic Test/div(II)I
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
return
.end method
