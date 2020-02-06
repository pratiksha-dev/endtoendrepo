/*
 * package com.scp.java.endtoend;
 * 
 * import java.util.Arrays;
 * 
 * class X{
 * 
 * public void m1(Integer []num1) { System.out.println("X"); }
 * 
 * 
 * public void m1(Integer ...num1) { System.out.println("X"); }
 * 
 * 
 * 
 * public void m1(Number []num1) { System.out.println("X[]"); } }
 * 
 * class Y extends X{
 * 
 * public void m1(Number ...num1) { System.out.println("Y"); } public void
 * m1(int num1) { System.out.println("Y-1"); } }
 * 
 * public class Demos {
 * 
 * public void calculation(int num2) { System.out.println("two params"); }
 * 
 * public void calculation(int []num1) { System.out.println("three params"); }
 * 
 * public static void main(String []args) {
 * 
 * } public static void main(String ...args) { System.out.println("main"); int
 * num[] = {10,203}; X y=new Y(); y.m1(num);
 * 
 * System.exit(0); A a = new A(); a.calculation(10);
 * 
 * 
 * 
 * C c= new C(); System.out.println(c);
 * 
 * B b1 = new C(); System.out.println("----------------------------"); B b2 =
 * new C(); System.out.println("----------------------------");
 * 
 * }
 * 
 * }
 * 
 * 
 * class A extends Demos{
 * 
 * public void calculation(int... nums) { //least params -- 1.5
 * System.out.println("zero or more params");
 * System.out.println(Arrays.toString(nums)); }
 * 
 * 
 * int v1; int v2;
 * 
 * { System.out.println("inside block of A"); }
 * 
 * static{ System.out.
 * println(" A- initialization of static fields -- Var+Methods on Method Area");
 * System.out.println("static block of A"); }
 * 
 * public A(int a) { super(); System.out.println("No-Arg -- A"); }
 * 
 * public A() { super(); }
 * 
 * }
 * 
 * class B extends A{ int b1; int b2;
 * 
 * public B(int a) { System.out.println("No-Arg -- B"); }
 * 
 * public B() { super(10); System.out.println("No-Arg -- B"); }
 * 
 * { System.out.println("inside block of B"); } static{ System.out.
 * println(" B- initialization of static fields -- Var+Methods on Method Area");
 * System.out.println("static block of B"); }
 * 
 * }
 * 
 * class C extends B{ int c1; int c2;
 * 
 * public C() { //super() super(2); return; //System.out.println("No-Arg -- C");
 * //return this; }
 * 
 * { System.out.println("inside block of C"); } static{ System.out.
 * println(" C- initialization of static fields -- Var+Methods on Method Area");
 * System.out.println("static block of C"); } }
 * 
 * 
 * 
 * Super This..
 * 
 */