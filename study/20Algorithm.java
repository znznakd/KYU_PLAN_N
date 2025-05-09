연속된 구간, 종류 등의 단어가 나오는 것으로 보아,  슬라이딩 윈도우, 투포인터 알고리즘과 HashMap 을 적절히 사용해서 풀면 된다고

생각했다. 항상 헷갈렸는데, 슬라이딩 윈도우를 적용해서 풀이할 때는 항상 최초 윈도우를 잘 설정해야 한다는 점 ..!

아래 코드를 보면 rt 값을 k - 1 로 설정해줬는데, rt = k 로 해버리면 최초 윈도우가 아니게되므로 꼭 꼭 주의하자.

그리고 항상 Value 가 0 인 값을 체크해서 제거해주면 된다.

강의를 보기 전에 정답을 맞춰서 따로 강의를 보지는 않았음 ㅎ.ㅎ

package studyReview.section04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer firstLine = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(firstLine.nextToken());
        int k = Integer.parseInt(firstLine.nextToken());

        StringTokenizer secondLine = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine.nextToken());
        }

        List<Integer> answer = solution(arr, n, k);
        answer.stream().forEach(s -> System.out.println(s + " "));
    }

    private static List<Integer> solution(int[] arr, int n, int k) {
        int lt = 0;
        int rt = k - 1;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        // rt = 3 이므로, 인덱스 0, 1, 2 까지만 최초 윈도우로 만들어준다.
        // 최초 윈도우의 크기는 항상 -1 해서 만들어주자. k 값 그대로 사용하면 윈도우를 움직이는 2번째 for 문에서 
        // 연속되는 값 4개가 아닌, 5개를 잡아버리기 때문에 오답이 뜬다.
        for (int i = 0; i < rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = rt; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size()); // i = rt 자체가 최초 윈도우에서 rt 가 뒤로 하나 더 간거니까 사이즈 더해주고,
            map.put(arr[lt], map.get(arr[lt]) - 1); // 다시 rt 를 뒤로 보내야 하니까 그전에 lt 값은 하나 빼주자.

            // 그리고 value 가 0 인 key 값이 있는지 검증 들어간다.
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }

            lt ++; // 그리고 lt 를 한 칸 뒤로 밀어주면서 rt 를 쫒아가는 형태
        }

        return answer;
    }
}
