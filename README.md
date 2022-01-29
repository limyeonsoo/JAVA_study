# JAVA

[1주차 : JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.](https://www.notion.so/1-JVM-9c39a7ddbe6d423f9b4f89936a90c73b)

[2주차 : 자바 데이터 타입, 변수 그리고 배열](https://www.notion.so/2-02e425050847494781dc7553c46008e7)

[3주차 : 연산자](https://www.notion.so/3-6ac266f7819043ca8316fecce7a3c3b5)

[4주차 : 제어문](https://www.notion.so/4-f8db039ee5444c15b47761a9a9fa350e)

[5주차 : 클래스](https://www.notion.so/5-ded43f83f3c745a78b39520b6203e160)

[6주차 : 상속](https://www.notion.so/6-3b68eaa5743b448f9b8372da2e5106d2)

[7주차 : 패키지](https://www.notion.so/7-0a8d639fa82f47578a5275421369de54)

[8주차 : 인터페이스](https://www.notion.so/8-3012fd7c929c4f939a378db305c005f8)

[9주차 : 예외처리](https://www.notion.so/9-c040e3ace4994bb49b1bc54953e6a62a)

[10주차 : 멀티쓰레드 프로그래밍](https://www.notion.so/10-d8e8df02c5da4afe91168a06680fdd66)

[11주차 : Enum](https://www.notion.so/11-Enum-49e855aee2d44281a176bfd511630c6e)

[12주차 : Annotation](https://www.notion.so/12-Annotation-32058769549c4c21a92af99e81903fb6)

[13주차 : 과제 I/O](https://www.notion.so/13-I-O-a3cc7ee765e74f018ea29b4d0220ae69)

[14주차 과제 : 제네릭](https://www.notion.so/14-8270447c83bb47609f7b1ec2ac7f93e9)

[15주차 : 람다식](https://www.notion.so/15-c7bc1fd1c1a14432b3d9c3c948fc1cc7)

[Frame](https://www.notion.so/Frame-2127b05f68d44be3a6be8f29571c7c2b)

# Java 1.4

오픈소스로 자바가 관리되기 시작한 버전.

[NIO](https://www.notion.so/NIO-a4d127621ba24101ae01b6f164c1d714)

[](https://www.notion.so/4fe05639cfb84e158f60c397ed7fe56a)

# Sorting

- 오름차순
    
    `Arrays.sort();`
    
- 내림차순
    
    `Arrays.sort(arr, Collections.reverseOrder());`
    
- 일부 정렬
    
    `Arrays.sort(arr, 0, 5);`
    
- 커스텀
    1. new Comparator 오버라이딩 하기
    
    ```java
    Arrays.sort(arr, new Comparator<String>() {
    	@Override
    	public int compare(String s1, String s2) {
    		return s1.length() - s2.length();
    	}
    }
    ```
    
    1. 람다식 사용하기
    
    ```java
    Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());
    ```
    
- 객체에 대한 정렬
    1. Comparable<> 를 구현하게 한다.
    2. compareTo를 오버라이드 한다.
    
    ```java
    public static class Example implements Comparable<Example> {
    	...
    	...
    	@Override
    	public int compareTo(@NotNull Example exam) {
    		return this.~ - exam.~;
    	}
    }
    ```
    

# String

```java
String.substring(시작인덱스);
String.substring(시작인덱스, 끝인덱스);
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
```

/ 끝 인덱스를 크게 했을 때, IndexOutOfBoundsException 발생.