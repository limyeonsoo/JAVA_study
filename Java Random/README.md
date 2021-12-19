# JAVA Random

# Java에서 사용할 수 있는 Random

## 1. util.Random의 Random

> LCG(Linear Congruential Generator)

![200px-Lcg_3d.gif](JAVA%20Random%2026fd8c810ccf43f782267df1083b3bdb/200px-Lcg_3d.gif)

시스템 시간을 입력받아 사용.

48bit

## 2. 이를 상속받는 java.security의 SecureRandom

> PRNG(Cryptographically Secure Pseudo-Random Number Generator)

운영 체제의 엔트로피를 입력 받아 사용.

128bit

> 비결정적 난수 제공.

# SecureRandom에서 사용할 수 있는 Random

SecureRandom.java

난수 발생기 역할을 하는 특수 파일.

발생 원리 ->

/dev/에 entropy를 생성하고

IO 디바이스 드라이버에 의해 발생하는 노이즈를 수집하여 난수 발생.

## 1. /dev/random

- 블로킹. Entropy가 충분한 임의성을 나타내지 않으면.
- 보안 -> 엔트로피가 최대치에 도달하지 않으면 차단되기 때문에 임의성이 안정적이어야 할 때 사용.

## 2. /dev/urandom

- 넌블로킹. Entropy가 충분하지 않아도 괜찮음.
- 난수가 지속적으로 필요하고 중요하지 않을 때.

엔트로피 양 & 엔트로피 풀 크기

cat /proc/sys/kernel/random/entropy_avail

cat /proc/sys/kernel/random/pool_size

SecureRandom.java

Note: Depending on the implementation, the generateSeed, reseed and nextBytes methods may block as entropy is being gathered, for example, if the entropy source is /dev/random on various Unix-like operating systems.

- Djava.security.egd=file:/dev/./urandom

엔트로피가 부족하면 충분한 암호화가 되지 않을텐데 사용해도 될까?

- > OS 설치 직후 라면 부족해서 문제가 될 수 있지만, 우리 상황은 그렇지 않다.