# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 개요

해당 저장소는 사다리 생성을 구현한 저장소입니다. `n`명의 사람 이름과 높이 `m`을 입력하면 사다리가 생성됩니다.

## 세부사항

플레이어

- 플레이어는 여러 명 존재할 수 있다.
    - [x] [제한사항] 플레이어는 2명 이상, 10명 이하만 가능하다.
    - [x] [제한사항] 플레이어의 이름은 중복될 수 없다.
- 플레이어는 이름을 가집니다.
    - [x] [제한사항] 이름은 영문자만 가능하다.
    - [x] [제한사항] 이름은 최대 5글자까지 가능하다.
    - [x] 이름의 앞, 뒤 공백은 제거한다.

방향

- [x] 왼쪽, 오른쪽, 정지를 가진다.
- [x] 값에 알맞은 방향을 반환한다.

선

- [ ] 방향들의 집합이다.

사다리

- [ ] 선들의 집합이다.
- [ ] 사다리를 생성한다.

방향 생성

- [ ] 랜덤 방향을 생성한다.

선 생성

- [ ] 방향 생성 전략에 따라 선을 생성한다.

입력

- [ ] 참여할 플레이어들의 이름을 입력한다.
- [ ] 최대 사다리 높이를 입력한다.

출력

- [ ] 사다리 생성 결과를 출력한다.
