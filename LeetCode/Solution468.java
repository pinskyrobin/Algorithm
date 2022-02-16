import java.util.Objects;

/**
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * <p>
 * 有效的 IPv4 地址 是 “x1.x2.x3.x4” 形式的 IP 地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。
 * 例如:“192.168.1.1”、 “192.168.1.0” 为有效 IPv4 地址， “192.168.01.1” 为无效 IPv4 地址; “192.168.1.00” 、 “192.168@1.1” 为无效 IPv4 地址。
 * <p>
 * 一个有效的 IPv6 地址是一个格式为 “x1:x2:x3:x4:x5:x6:x7:x8” 的 IP 地址，其中:
 * <p>
 * 1 <= xi.length <= 4
 * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 在 xi 中允许前导零。
 * 比如，2001:0db8:85a3::8A2E:0370:7334和 2001:db8:85a3:0:0:8A2E:0370:7334 是有效的 IPv6 地址。
 * 而 2001:0db8:85a3::8A2E:037j:7334 和 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution468 {
	public static void main(String[] args) {
		System.out.println(validIPAddress("172.16.254.1"));
	}

	public static String validIPAddress(String queryIP) {
		if (Objects.equals(queryIP, "") || queryIP.charAt(queryIP.length() - 1) == '.' ||
				queryIP.charAt(queryIP.length() - 1) == ':')
			return "Neither";

		String[] strs;
		if (queryIP.contains(":") && queryIP.contains(".")) return "Neither";
		if (queryIP.contains(":")) strs = queryIP.split(":");
		else if (queryIP.contains(".")) strs = queryIP.split("\\.");
		else return "Neither";

		if (strs.length == 4) {
			for (String str : strs) {
				// 空串或前导0
				if (str.length() == 0 || str.length() > 3 ||
						(str.length() > 1 && str.charAt(0) == '0') ||
						str.charAt(0) < '0' || str.charAt(0) > '9')
					return "Neither";

				int number = str.charAt(str.length() - 1) - '0';
				if (str.length() > 1)
					if (str.charAt(1) < '0' || str.charAt(1) > '9') return "Neither";
					else number += (str.charAt(str.length() - 2) - '0') * 10;

				if (str.length() > 2)
					if (str.charAt(2) < '0' || str.charAt(2) > '9') return "Neither";
					else number += (str.charAt(0) - '0') * 100;
				if (number > 255) return "Neither";
			}
			return "IPv4";
		} else if (strs.length == 8) {
			for (String str : strs) {
				if (str.length() < 1 || str.length() > 4) return "Neither";
				for (int j = 0; j < str.length(); j++) {
					char ch = str.charAt(j);
					if (!((ch >= '0' && ch <= '9') ||
							(ch >= 'a' && ch <= 'f') ||
							(ch >= 'A' && ch <= 'F')))
						return "Neither";
				}
			}
			return "IPv6";
		}
		return "Neither";
	}
}