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
bipush 50
istore_0
bipush 5
istore_1
bipush 101
istore_2
iload_1
bipush 3
if_icmpgt L1
iload_0
bipush 10
if_icmpgt L1
iload_2
bipush 100
if_icmpgt L1
iload_2
bipush 99
if_icmpgt L1
iload_2
bipush 10
if_icmpgt L1
iload_1
bipush 5
if_icmpeq L1
iload_0
bipush 5
if_icmpne L1
iload_2
bipush 5
if_icmpge L1
goto L2
L1:
; unused label: L2
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_1
invokevirtual java/io/PrintStream.println(I)V
goto L3
L2:
getstatic java/lang/System/out Ljava/io/PrintStream;
iload_2
invokevirtual java/io/PrintStream.println(I)V
L3:
return
.end method
