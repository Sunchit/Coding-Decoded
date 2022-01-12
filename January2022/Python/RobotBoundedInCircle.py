#Author :  Karthik K ( https://www.linkedin.com/in/karthikmunirathinam/ )

# TC : O(n)
# SC : O(1)

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x,y=0,0
        dirX,dirY=0,1
        for direction in instructions:
            if direction=='G':
                x,y=x+dirX,y+dirY
            elif direction=='L':
                dirX,dirY=-1*dirY,dirX
            else:
                dirX,dirY=dirY,-1*dirX
        return (x,y)==(0,0) or (dirX,dirY)!=(0,1)