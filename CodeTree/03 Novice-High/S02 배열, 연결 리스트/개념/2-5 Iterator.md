# Iterator

- 연결 리스트에서 삽입, 삭제를 바로할 수 있는 위치는 맨 앞과 맨 뒤 밖에 없음.
  - 연결 리스트는 삽입과 삭제가 잦은 상황에서 사용하기 좋은 자료구조라고 했는데, **가운데에 있는 특정 위치에 대해 `삽입/삭제`** 가 가능해야 더 좋은 구조임.
  - 가운데 특정 위치에 삽입/삭제 하기 위해서는 탐색 O(N), 삽입/삭제 O(1)의 시간복잡도가 필요

## Iterator의 등장

- 연결리스트와는 별도로, 자유자재로 값을 순환할 수 있는 구조.
- 반복자라고도 부름
- 배열에서는 index를 이용해 특정 위치의 원소를 바로 구할 수 있던 것처럼, iterator를 이용해서 특정 위치를 지정할 수 있음.
    - iterator 값이 주어지면, prev/next 값을 활용하여 빠르게 삽입/삭제 수행.
      - 탐색 속도가 O(1)이 된다.


### Case 1. iterator를 유지하지 않고 삽입 진행하는 경우

- 상황: 앞에서 2번째 데이터 앞에 새 노드 추가 후, 다시 3번째 데이터 앞에 새 노드 추가하는 경우

<img src="https://contents.codetree.ai/problems/506/images/4ff1fbda-259b-4685-8770-ff29515fa021.png">

- 처음에 2번째 데이터를 탐색할 때 O(N) 소요.

<img src="https://contents.codetree.ai/problems/506/images/3b9215f5-21c3-4aa2-b2dd-5332ccb10b95.png">

- 새로운 데이터 삽입 시간 O(1) 소요.

<img src="https://contents.codetree.ai/problems/506/images/7b095857-ab6d-477c-ae0e-79bd8bd8c750.png">

- 다시 새 노드를 추가하기 위해, 3번째 데이터를 찾는 탐색 시간 O(N) 소요.
- 삽입 시간은 O(1) 소요.

<br>

### Case2. 기존 iterator를 유지하며 삽입하는 경우

<img src="https://contents.codetree.ai/problems/506/images/6ddc6b31-e3df-4659-a4fc-7230956406dd.png">

- 2번째 데이터 찾는 시간 O(N)
  - 이 때 iterator는 head에서 시작하여 계속 next값을 조회하며 이동

<img src="https://contents.codetree.ai/problems/506/images/1af5f4ec-1b2d-4a85-820f-2414df5fa892.png">

- 데이터 삽입 시간은 O(1)
- 이제 3번째 데이터를 찾아야 하지, 이미 2번째 데이터를 iterator가 가리키고 있다.
  - 그 다음 위치로 이동만하면 3번째 데이터를 찾을 수 있음.
  - 즉, **3번째 데이터를 찾는데 걸리는 시간은 O(1)**

<img src="https://contents.codetree.ai/problems/506/images/59a6e172-670a-482d-8b83-650fc034b313.png">

- 이후 삽입 시간은 O(1)
- **이렇게 연결 리스트의 조회/삽입/삭제 가 이전에 살펴보던 위치와 밀접하게 관련있는 경우, iterator를 이용하였을 때 탐색 시간을 효과적으로 줄일 수 있다.**