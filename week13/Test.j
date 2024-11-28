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
bipush 4
istore_0
bipush 0
istore_1
bipush 1
istore_2
iload_0
bipush 3
if_icmpne L1
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_1
invokevirtual java/io/PrintStream.println(I)V
goto L2
L1:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_2
invokevirtual java/io/PrintStream.println(I)V
L2:
iload_0
bipush 3
if_icmple L3
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_1
invokevirtual java/io/PrintStream.println(I)V
goto L4
L3:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_2
invokevirtual java/io/PrintStream.println(I)V
L4:
iload_0
bipush 7
if_icmple L5
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_2
invokevirtual java/io/PrintStream.println(I)V
L5:
return
.end method
