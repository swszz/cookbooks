# DDD with Hexagonal Architecture

## 소개
DDD (Domain Driven Development)와 Hexagonal Architecture 를 기반으로 하는 애플리케이션 설계에 대한 샘플 프로젝트

## 단어 정리
예시로 작성한 요소들은 사실과 다르며, 이해를 돕기 위한 예시입니다.

### Domain
  - 우리가 해결하고자 하는 주제에 대한 영역 & 핵심 비즈니스
  - 배달의 민족 도메인은 크게 \[가게\] - \[결제\] - \[주문\] - \[배달\] 으로 구분된다.

### Domain Model
  - 도메인을 구성하는 요소를 개념 관점에서 추상적으로 구조화한 것
  - 배달의 민족 도메인 중 결제 도메인에는 \[결제 수단\] 이라는 도메인 모델이 존재하며, 서브 도메인 모델로는 \[카드\], \[현금\] 등이 존재한다.  

### Domain Object (Domain Model Object)
  - 도메인 모델을 소프트웨어 또는 코드 레벨에서 표현한 것
  - `class Order() {} ...`

### Hexagonal Architecture
  - 인터페이스나 Infrastructure의 변경에 영향을 받지 않는 핵심 코드를 만들고 이를 견고하게 관리하는 아키텍쳐 구성 방법론
    - Ports And Adapters Architecture 로 표현하기도 한다.
  - ref. [Hexagonal Architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software))