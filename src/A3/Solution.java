package A3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	// 현재 받아온 덱을 저장할 배열 (clone을 사용하면 공간복잡도가 터지게 되므로, 이를 방지하기 위해 모든 값을 static으로 관리합니다.)
	static int[]	deck = new int[12];
	// 셔플 과정에서 카드를 임시로 놓을 셔플용 배열
	static int[]	temp = new int[12];
	// 이전 셔플에서 넘겨받은 덱의 원본 상태를 저장할 배열 (셔플을 해본 이후에 다시 덱을 원상복구 해야하므로 이전 상태를 그대로 가져올 용도입니다.)
	static int[][]	depthSave = new int[5][12];
	static int		deckSize;
	static int		halfSize;
	static int		ans;
	public static void main(String[] args) throws Exception {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int				testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++)
		{
			sb.append('#').append(tc).append(' ');
			// 5번 이상 셔플하면 -1이 되어야 하므로 일단 6으로 설정해 놓은 뒤 나중에 6인지 아닌지 체크해봅시다.
			ans = 6;
			deckSize = Integer.parseInt(br.readLine());
			// 덱 사이즈가 12라면, 카드를 절반으로 나누었을 때 왼쪽 카드더미의 시작 인덱스는 0, 오른쪽 카드더미의 시작 인덱스는 6이 됩니다.
			// halfSize는 이 오른쪽 카드더미의 시작 인덱스와 동일하고, 추후에 여러 연산에서 쓰이게 됩니다.
			halfSize = deckSize / 2;
			st = new StringTokenizer(br.readLine());
			// 덱을 입력받습니다.
			for (int i = 0; i < deckSize; i++)
				deck[i] = Integer.parseInt(st.nextToken());
			// Dfs로 모든 경우를 탐색합니다.
			// 이 때 시간 복잡도는 O((deckSize - 1)^5 * deckSize * 4)
			// 덱을 섞는 0번 연산은 이전 카드를 그대로 가져가는 것이므로 필요가 없습니다 따라서 카드를 섞는 경우의 수(deckSize - 1)를 중복하여 5번 뽑는 중복순열이므로
			// 첫 항이 (deckSize - 1)^5 입니다.
			// 두번째 항인 deckSize * 4는 
			// 매 사이클마다 덱을 셔플한 뒤 임시배열에 저장하는 for문의 unit 시간복잡도 deckSize
			// 매 사이클마다 임시 배열에 저장되어있던 셔플된 덱을 원본 덱에 저장하는 for문의 unit 시간복잡도 deckSize
			// 매 사이클마다 다음 셔플을 위해 덱을 원본 덱으로 복원하는 for문의 unit 시간복잡도 deckSize
			// 매 사이클마다 정렬이 되었는지 확인하는 for문의 unit 시간복잡도 deckSize
			// 총 4번의 O(DeckSize) 유닛을 호출하므로 이러한 결과가 나오게 됩니다.
			// 첫 항이 작기 때문에 두번째 항이 시간복잡도에 많은 영향을 끼치므로 이를 고려해주어야 합니다.
			// 동시에 만약 이 과정을 Clone을 사용하여 구현하게 된다면
			// 공간복잡도는
			// O((deckSize - 1)^5 * (deckSize * 4))이므로
			// 여러가지를 고려해야 하는 문제입니다.
			Dfs(0);
			// 만약 완전히 탐색했을 때 ans가 여전히 6이라면 정렬이 실패한 것이므로
			// ans에 -1을 넣어줍니다.
			if (ans == 6)
				ans = -1;
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// depth = 셔플 횟수
	public static void Dfs(int depth)
	{
		// 만약 정렬되었다면
		// ans에 현재 셔플 횟수와 ans의 min값을 저장해줍니다.
		if (checkSorted())
			ans = Math.min(depth, ans);
		// 5번 셔플 했다면 더이상 셔플은 할 필요가 없습니다. return합니다.
		if (depth == 5)
			return ;
		// 이전 셔플의 결과를 저장해두어야 셔플 할 때마다 이를 복원해서 사용할 수 있습니다. 따라서 이를 저장해주는 코드입니다.
		for (int i = 0; i < deckSize; i++)
			depthSave[depth][i] = deck[i];
		// 셔플을 하는데, 0번 셔플은 필요가 없으므로, 1부터 deckSize - 1까지의 셔플 종류를 이용해 중복 순열을 만듭니다
		for (int i = 1; i < deckSize; i++)
		{
			// 셔플
			shuffle(i);
			// 재귀적으로 보내기 
			Dfs(depth + 1);
			// 덱을 복원 시키기
			for (int j = 0; j < deckSize; j++)
				deck[j] = depthSave[depth][j];
		}
	}
	
	// 정렬이 되어있는지 확인하는 코드입니다.
	// 오름차순 내림차순까지 확인할 필요가 없기 때문에 매우 쉬운 방법으로 확인해보겠습니다.
	public static boolean checkSorted()
	{
		// 덱을 돌며
		for (int i = 1; i < deckSize; i++)
		{
			// 이전 카드의 번호와 현재 번호의 차의 절댓값이 1이 아니라면
			// 정렬이 안된 것이므로 false를 return 합니다.
			if (Math.abs(deck[i] - deck[i - 1]) != 1)
				return (false);
		}
		// for문을 모두 돌 때 까지 종료가 안되었다면 정렬이 된 것이므로 true입니다.
		return (true);
	}
	
	//n = 셔플의 종류
	public static void shuffle(int n)
	{
		// 셔플은 두 개의 공간을 가지고 진행합니다.
		// i는 임시 배열의 index입니다.
		int i = 0;
		// leftIndex는 0부터 시작합니다.
		int	leftIndex = 0;
		// rightIndex는 halfSize부터 시작합니다.
		int rightIndex = halfSize;
		// 셔플의 종류에 대해 어떻게 정렬해야하는지 규칙은 직접 index와 셔플의 종류를 바탕으로 확인해보아야 알 수 있습니다.
		// 이 코드는 수 많은 셔플의 구현 방법중 하나이며 자세한 내용은 생략하겠습니다.
		if (n < halfSize)
		{
			while (n < halfSize - leftIndex)
				temp[i++] = deck[leftIndex++]; 
			while (leftIndex < halfSize)
			{
				temp[i++] = deck[rightIndex++];
				temp[i++] = deck[leftIndex++];
			}
			while (rightIndex < deckSize)
				temp[i++] = deck[rightIndex++];
		}
		else
		{
			while (rightIndex <= n)
				temp[i++] = deck[rightIndex++];
			while (rightIndex < deckSize)
			{
				temp[i++] = deck[leftIndex++];
				temp[i++] = deck[rightIndex++];
			}
			while (leftIndex < halfSize)
				temp[i++] = deck[leftIndex++];
		}
		for (i = 0; i < deckSize; i++)
			deck[i] = temp[i];
	}
}
