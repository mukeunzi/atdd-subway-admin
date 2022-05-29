<p align="center">
    <img width="200px;" src="https://raw.githubusercontent.com/woowacourse/atdd-subway-admin-frontend/master/images/main_logo.png"/>
</p>
<p align="center">
  <img alt="npm" src="https://img.shields.io/badge/npm-6.14.15-blue">
  <img alt="node" src="https://img.shields.io/badge/node-14.18.2-blue">
  <a href="https://edu.nextstep.camp/c/R89PYi5H" alt="nextstep atdd">
    <img alt="Website" src="https://img.shields.io/website?url=https%3A%2F%2Fedu.nextstep.camp%2Fc%2FR89PYi5H">
  </a>
  <img alt="GitHub" src="https://img.shields.io/github/license/next-step/atdd-subway-admin">
</p>

<br>

# 지하철 노선도 미션
[ATDD 강의](https://edu.nextstep.camp/c/R89PYi5H) 실습을 위한 지하철 노선도 애플리케이션

<br>

## 🚀 Getting Started

### Install
#### npm 설치
```
cd frontend
npm install
```
> `frontend` 디렉토리에서 수행해야 합니다.

### Usage
#### webpack server 구동
```
npm run dev
```
#### application 구동
```
./gradlew bootRun
```
<br>

## ✏️ Code Review Process
[텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

<br>

## 🐞 Bug Report

버그를 발견한다면, [Issues](https://github.com/next-step/atdd-subway-admin/issues) 에 등록해주세요 :)

<br>

## 📝 License

This project is [MIT](https://github.com/next-step/atdd-subway-admin/blob/master/LICENSE.md) licensed.


---

## 인수 테스트 주도 개발 미션
### 기능 목록 도출

### 1단계 - 지하철역 인수 테스트
- [X] 지하철역 도메인 리팩토링
- [X] 지하철역 생성 인수 테스트 작성
  - 지하철 역 생성하기
    - When. 지하철역을 생성하면
    - Then. 지하철역이 생성된다.
  - 중복된 지하철역 생성하기
    - Given. 지하철역을 생성하고
    - When. 기존에 존재하는 지하철역 이름으로 지하철역을 생성하면
    - Then. 지하철역이 생성이 안된다.
- [X] 지하철역 목록 조회 인수 테스트 작성
  - 지하철역을 조회한다.
    - Given. 2개의 지하철역을 생성하고
    - When. 지하철역 목록을 조회하면
    - Then. 2개의 지하철역을 응답 받는다.
- [X] 지하철역 삭제 인수 테스트 작성
    - 지하철역을 제거한다.
        - Given. 지하철역을 생성하고
        - When. 그 지하철역을 삭제하면


### 2단계 - 지하철 노선 기능
**지하철 노선에 대한 인수 테스트 시나리오 작성**

- [X]  지하철 노선 생성 인수테스트 작성
  - When 지하철 노선을 생성하면
  - Then 지하철 노선 목록 조회 시 생성한 노선을 찾을 수 있다.
- [X]  지하철 노선 목록 조회 인수테스트 작성
  - Given 2개의 지하철 노선을 생성하고
  - When 지하철 노선 목록을 조회하면
  - Then 지하철 노선 목록 조회 시 2개의 노선을 조회할 수 있다.
- [X]  지하철 노선 조회 인수테스트 작성
  - Given 지하철 노선을 생성하고
  - When 생성한 지하철 노선을 조회하면
  - Then 생성한 지하철 노선의 정보를 응답받을 수 있다.
- [X]  지하철 노선 수정 인수테스트 작성
  - Gvien 지하철 노선을 생성하고
  - When 생성한 지하철 노선을 수정하면
  - Then 해당 지하철 노선 정보는 수정된다.
- [X]  지하철 노선 삭제 인수테스트 작성
  - Given 지하철 노선을 생성하고
  - When 생성한 지하철 노선을 삭제하면
  - Then 해당 지하철 노선 정보는 삭제된다.


**자하철 노선 기능 구현**

- [X]  지하철 노선 도메인 개발
- [X]  지하철 노선 도메인 테스트 코드 작성
- [X]  지하철 구간 도메인 개발
- [X]  지하철 구간 도메인 테스트 코드 작성
- [X]  지하철 노선과 지하철 구간의 연관관계 매핑
- [X]  지하철 구간과 지하철 역의 연관관계 매핑

**지하철 노선 기능에 대한 인수 테스트 API 구현**

- [X]  지하철 노선 생성 API
- [X]  지하철 노선 전체 조회 API
- [X]  지하철 노선 단일 조회 API
- [X]  지하철 노선 수정 API
- [X]  지하철 노선 삭제 API
 
- [X]  인수테스트 격리시키기
- [X]  인수테스트 리팩토링

### 3단계 - 구간 추가 기능
**지하철 구간 등록 인수 테스트 작성과 기능 구현**
- [X]  기존 노선 중간에 새로운 역을 추가할 수 있다. - 인수 테스트 작성 (실패하는 인수테스트)
  * Given : 추가할 노선 구간을 생성하고
  * When : 기존 생성된 노선에 구간을 추가하면
  * Then : 노선이 추가된다.
- [X]  노선(Line)에 등록된 역들을 순서대로 조회할 수 있다. - 인수 테스트 작성 (실패하는 인수테스트)
  * Given : 추가할 노선 구간을 생성하고
  * When : 기존 생성된 노선에 구간을 추가한다.
  * Then : 기존 노선에 새로운 구간이 추가된다
  * When : 노선에 등록된 역을 조회하면
  * Then : 노선에 등록된 역들이 순서대로 조회된다.
- [X]  기존 노선에 새로운 역을 상행 종점으로 추가할 수 있다. - 인수 테스트 작성 (실패하는 인수테스트)
  * Given : 새로운 상행 종점을 위해 추가할 노선 구간을 생성하고
  * When : 기존 생성된 노선에 구간을 추가하면
  * Then : 기존 노선에 새로운 구간이 추가된다
  * When : 노선에 등록된 역을 조회하면
  * Then : 상행역이 추가된 결과로 지하철 역이 순서대로 조회된다.
- [X]  기존 노선에 새로운 역을 하행 종점으로 추가할 수 있다. - 인수 테스트 작성 (실패하는 인수테스트)
  * Given : 새로운 하행 종점을 위해 추가할 노선 구간을 생성하고
  * When : 기존 생성된 노선에 구간을 추가하면
  * Then : 기존 노선에 새로운 구간이 추가된다
  * When : 노선에 등록된 역을 조회하면
  * Then : 하행역이 추가된 결과로 지하철 역이 순서대로 조회된다.
- [X]  노선(Line)에 구간(Section) 등록 도메인 로직 구현
- [X]  노선(Line)에 이미 등록된 상/하행 구간(Section)에 대한 상/하행역 갱신 도메인 로직 구현
- [X]  지하철 구간 등록에 대한 API 개발
- [X]  작성된 인수테스트 통과 검증

**구간 등록 관련 예외 케이스 처리 인수 테스트를 작성한다.**
- [X]  역 사이에 새로운 역을 추가하는 경우 기존 역 사이 길이보다 크거나 같으면 등록할 수 없음
  * Given : 추가할 노선 구간을 생성하고 (기존 노선 거리보다 짧게)
  * When : 기존 생성된 노선에 구간을 추가하면
* Then : 추가를 시도한 구간이 등록되지 않는다.
- [X]  상행역과 하행역이 이미 노선에 모두 등록되어 있다면 추가할 수 없음
  * Given : 기존에 존재하는 역으로 구성된 추가 노선을 생성하고
    * 기존 : 강남역 - 광교역 (2개만 존재)
  * When : 기존 생성된 노선에 구간을 추가하면
    * 추가하려는 구간 : 강남역 - 광교역
  * Then : 추가를 시도한 구간이 등록되지 않는다.
- [X]  구간에 존재하는 상행역과 하행역 둘 중 하나도 노선에 포함되어있지 않으면 추가할 수 없음(기존 역이 1개 포함되어 있어야함)
  * Given : 기존 노선에 없는 역들로 구성된 구간을 생성한다.
  * When : 기존 노선에 생성한 구간을 추가한다.
  * Then : 추가를 시도한 구간이 등록되지 않는다.


### 4단계 : 구간 제거 기능

**노선의 구간을 제거하는 기능 구현하기**
- [X]  인수조건 : 종점이 제거될 경우 다음으로 오던 역이 종점이 된다. (역 조정)
  * Given : 노선에 A-B-C 역이 존재한다. 상행 종점은 A, 하행 종점은 C 이다. 
  * When : 상행종점 A를 제거한다. 
  * When : 지하철 노선의 역을 조회한다. 
  * Then : B-C 순서로 역이 조회된다.
- [X]  인수 조건 : 중간역이 제거될 경우 재배치를 한다.
  * Given : 노선에 A-B-C 역이 존재한다. 상행 종점은 A, 하행 종점은 C이다.
  * When : 중간 역인 B역을 제거한다.
  * When : 지하철 노선의 역을 조회한다.
  * Then : A-C 순서로 역이 조회된다. 
        
- [X]  종점이 제거될 경우 다음 역이 종점이 되는 인수조건을 만족하기 위한 도메인 기능 개발 
  * 제거할 대상 역이 종점 제거대상이고 상행인 경우 상행 다음 역이 종점이 된다.
  * 제거할 대상 역이 종점 제거대상이고 하행인 경우 하행 이전 역이 종점이 된다.
        
- [X]  제거하고자 하는 역이 종점이 아니면서 존재하는 역인 경우 역들이 재배치되는 도메인 기능 개발
  * 제거 대상의 역의 이전 역과 다음 역을 하나의 구간으로 생성해낸다.
  * 이 때 구간의 거리는 두 구간의 합이다.
    
- [X]  인수 테스트를 위한 구간 제거 API 개발
- [X]  구간 제거 인수 테스트 패스
    
**구간 삭제 시 예외 케이스 고려하기**
- [X]  인수 조건 : 노선에 등록되어 있지 않은 역을 제거하는 경우 제거할 수 없다.
  * Given : 노선에 A-B 역이 존재한다.
  * When : C역을 제거한다.
  * Then : 노선에 존재하지 않는 역임으로 제거되지 않는다.
        
- [X]  인수 조건 : 구간이 하나인 노선에서 마지막 구간을 제거할 때 제거되지 않는다.
  * Given : 노선에 A-B 역이 존재한다.
  * When : A역을 제거한다.
  * Then : 마지막 구간의 역임으로 제거되지 않는다.
        
- [ ]  노선에 존재하지 않은 역을 제거할 시 유효성 검증을 통해 예외처리가 된다.
- [ ]  노선 마지막 구간의 역을 제거할 시 유효성 검증을 통해 예외처리가 된다.
- [ ]  인수테스트 패스