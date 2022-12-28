# Scanner와 BufferedReader 차이

| 설명 | Scanner | BufferedReader |
| --- | --- | --- |
| 적합 용도 | Simple tasks: single word or number from the user | Large amounts of data: structured file(eg.CSV) |
| 읽는 양 | Read: one token(word or number) at a time | Read: one line at a time |
| 속도 | Slower | Faster |
| 타입 | Handles type conversions | Handles the raw input as a String |
| 스레드 | Not thread-safe | Thread-safe |