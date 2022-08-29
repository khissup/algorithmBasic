package A2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int		size = 0;
	// 몬스터와 집을 저장할 배열
	static int[][]	monster = new int[4][2];
	static int[][]	home = new int[4][2];
	static int		monCount;
	static int		homeCount;
	static int		ans;
	public static void main(String[] args) throws Exception {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int				testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++)
		{
			ans = 1000000007;
			monCount = 0;
			homeCount = 0;
			size = Integer.parseInt(br.readLine());
			for (int y = 0; y < size; y++)
			{
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < size; x++)
				{
					int	temp = Integer.parseInt(st.nextToken());
					// 만약 temp가 0보다 크다는 것은, 몬스터라는 의미입니다. 몬스터의 번호가 중요하므로 index를 몬스터 번호 - 1로 설정합니다.
					// 동시에 몬스터의 수를 하나 증가시킵니다.
					if (temp > 0)
					{
						monster[temp - 1][0] = x;
						monster[temp - 1][1] = y;
						monCount++;
					}
					// 그 반대는 집이라는 의미이므로 동일하게 index를 집 번호 - 1로 지정합니다.
					// 이 때 집 번호는 음수이므로 절댓값 연산을 해주어야 합니다.
					if (temp < 0)
					{
						home[Math.abs(temp) - 1][0] = x;
						home[Math.abs(temp) - 1][1] = y;
						homeCount++;
					}
				}
			}
			// 다 받아왔다면, 집과 몬스터의 방문 순서에 대한 순열을 만듭니다. 이 때 시간복잡도는 O((homeCount + monCount)!)
			perm(0, 0, 0, 0, 0);
			sb.append('#').append(tc).append(' ');
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// monVisit = 몬스터에 대한 방문 처리용 비트마스킹 변수
	// homeVisit = 집에 대한 방문 처리용 비트마스킹 변수
	// x , y = 이전에 헌터가 서있던 좌표
	// dist = 지금까지 헌터가 이동한 거리
	public static void perm(int monVisit, int homeVisit, int x, int y, int dist)
	{
		// 집과 몬스터 모두 방문했다면
		if (monVisit == (1 << monCount) - 1 && homeVisit == (1 << homeCount) - 1)
		{
			// ans와 dist를 min연산하여 ans에 저장합니다.
			ans = Math.min(ans, dist);
			return ;
		}
		// 몬스터를 방문해봅니다.
		for (int i = 0; i < monCount; i++)
		{
			// 만약 몬스터가 이미 방문한 몬스터라면 continue
			if ((monVisit & (1 << i)) != 0)
				continue ;
			// 몬스터를 방문한다는 것은 현재 헌터의 좌표 x, y에서 몬스터가 있는 좌표로 이동했다는 것이므로
			// 몬스터가 있는 좌표가 헌터의 좌표가 됩니다.
			// 동시에, 헌터의 좌표와 몬스터의 좌표로 맨해튼 거리를 계산한다면, 이 거리가 바로 이동 거리가 됩니다.
			// 따라서 이를 연산해 준 후에 다음 순열 함수로 넘겨줍니다.
			perm(monVisit | (1 << i), homeVisit, monster[i][0], monster[i][1],
					dist + Math.abs(x - monster[i][0]) + Math.abs(y - monster[i][1]));
		}
		// 집을 방문해봅니다.
		for (int i = 0; i < homeCount; i++)
		{
			// 집을 방문할 때에는 해당 집 번호와 동일한 몬스터도 방문했던 상태여야 합니다.
			// 따라서 만약 집을 방문할 때 해당하는 번호의 몬스터를 방문하지 않았다면 집에 방문할 필요가 없습니다.
			// 나머지는 몬스터를 방문하는 경우와 동일합니다.
			if ((homeVisit & (1 << i)) != 0 || (monVisit & (1 << i)) == 0)
				continue ;
			perm(monVisit, homeVisit | (1 << i), home[i][0], home[i][1],
					dist + Math.abs(x - home[i][0]) + Math.abs(y - home[i][1]));
		}
	}
}
