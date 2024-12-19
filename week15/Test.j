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
bipush 96
istore_0
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
iload_0
bipush 1
if_icmpeq L1
iload_0
bipush 10
if_icmplt L2
iload_0
bipush 21
if_icmplt L3
L2:
iload_0
bipush 2
if_icmpeq L4
iload_0
bipush 3
if_icmpeq L4
iload_0
bipush 5
if_icmpeq L4
iload_0
bipush 7
if_icmpeq L4
goto L5
L1:
iload_0
bipush 9
iadd
istore_0
goto L5
L3:
iload_0
bipush 3
iadd
istore_0
goto L5
L4:
iload_0
bipush 2
iadd
istore_0
goto L5
L5:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_0
invokevirtual java/io/PrintStream.println(I)V
return
.end method
