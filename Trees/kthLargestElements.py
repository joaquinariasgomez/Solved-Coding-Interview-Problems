from heapq import *

class KthLargestNumberInStream:
    minHeap = []

    def __init__(self, nums):
        for num in nums:
            self.add(num)

    def add(self, num):
        heappush(self.minHeap, num)
        print(self.minHeap)

def main():
    kthLargestNumber = KthLargestNumberInStream([3, 100, 36, 17, 25, 48, 19])

main()
