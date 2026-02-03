def maxProfit(prices):
    minPrice = float('inf')
    maxProfit = 0

    for price in prices:
        if price < minPrice:
            minPrice = price

        profit = price - minPrice

        if profit > maxProfit:
            maxProfit = profit

    return maxProfit


if __name__ == "__main__":
    tests = [
        [7, 1, 5, 3, 6, 4],
        [7, 6, 4, 3, 1],
        [1, 2, 3, 4, 5],
        [5],
        [3, 3, 3, 3],
        [5, 4, 3, 2, 10]
    ]

    for t in tests:
        print(t, "->", maxProfit(t))
