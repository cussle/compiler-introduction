; --- 피보나치 수를 구하는 프로그램 (JVM Assembly) ---
; File: Fib.j
; Purpose: n번째 피보나치 수를 구하여 출력

.class public examples/Fib
.super java/lang/Object

; 표준 초기화 메서드
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

; fib 함수 - n번째 피보나치 수를 반환
.method public static fib(I)I
    ; 지역 변수 및 스택 크기 제한
    .limit locals 5
    .limit stack 3

    ; n이 0 이하인 경우 0 반환
    iload_0
    ifle Zero
    ; n이 1인 경우 1 반환
    iload_0
    iconst_1
    if_icmpeq One

    ; 변수 초기화
    iconst_0       ; a = 0
    istore_1
    iconst_1       ; b = 1
    istore_2
    iconst_2       ; count = 2
    istore_3

Loop:
    ; count <= n 검사
    iload_3
    iload_0
    if_icmpgt EndLoop

    ; temp = a + b 계산
    iload_1
    iload_2
    iadd
    istore 4       ; temp에 저장

    ; a = b, b = temp
    iload_2
    istore_1
    iload 4
    istore_2

    ; count 증가
    iinc 3 1
    goto Loop

EndLoop:
    ; b 반환 (n번째 피보나치 수)
    iload_2
    ireturn

Zero:
    iconst_0
    ireturn

One:
    iconst_1
    ireturn
.end method

; main 함수 - fib 함수를 호출하여 결과를 출력
.method public static main([Ljava/lang/String;)V
    .limit locals 3
    .limit stack 3

    ; System.out 객체 가져오기
    getstatic java/lang/System/out Ljava/io/PrintStream;
    astore_1

    ; fib(10) 호출
    bipush 10
    invokestatic examples/Fib/fib(I)I
    istore_2

    ; 결과를 문자열로 변환하여 출력
    iload_2
    invokestatic java/lang/String/valueOf(I)Ljava/lang/String;
    astore_2

    ; 결과를 출력
    aload_1
    aload_2
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V

    return
.end method
