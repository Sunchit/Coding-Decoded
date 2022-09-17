// Author: Shobhit Behl (LC: shobhitbruh)
internal class CountAllValid {
    fun countOrders(n: Int): Int {
        val dp = LongArray(n + 1)
        dp[1] = 1
        val mod: Long = 1000000007
        for (i in 2 until n + 1) {
            dp[i] = (2 * i - 1) * (2 * i) / 2 * dp[i - 1] % mod
        }
        return dp[n].toInt()
    }
}