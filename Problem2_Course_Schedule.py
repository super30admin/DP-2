from collections import defaultdict
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        The idea is to return false when a cycle is detected
        add the couese number in key and list as values
        Time complexity: O(P+C) where C is number of courses and P is number of edges(prerequisites)
        Space Complexity: O(P+C) for the hashtable
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        prereqs =  defaultdict(list)
        #add the courses and prereqs in this hastable
        for c, p in prerequisites:
            prereqs[c].append(p)
        
        seen = set()
        
        def cycle(course, seen):
            if course in seen:
                return True

            seen.add(course)
            for p in prereqs[course]:
                if cycle(p, seen):
                    return True
            prereqs[course] = []
            seen.remove(course)
            return False
        
        
        for course in range(numCourses):
            if cycle(course, seen):
                return False
        return True