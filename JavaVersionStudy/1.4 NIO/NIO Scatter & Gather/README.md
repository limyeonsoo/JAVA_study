# NIO Scatter & Gather

Buffer는 여러개인데,
Channel은 1개이다.

## Scatter

channel → Buffer들 로 read할 때.

![Untitled](Untitled.png)

Buffer 1개를 다 채워야 2번째 버퍼로 감.

즉, 고정 크기

128 header 버퍼를 채우면,
1024 body 버퍼로 감.

```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body   = ByteBuffer.allocate(1024);

ByteBuffer[] bufferArray = { header, body };

channel.read(bufferArray);
```

## Gather

![Untitled](Untitled%201.png)

Buffer가 128로 만들어져있지만,
일부만 채워져있을 경우에 채워진 부분만 Channel에 Write함.

```java
ByteBuffer header = ByteBuffer.allocate(128);
ByteBuffer body   = ByteBuffer.allocate(1024);

//write data into channel

ByteBuffer[] bufferArray = { header, body };

channel.write(bufferArray);
```
