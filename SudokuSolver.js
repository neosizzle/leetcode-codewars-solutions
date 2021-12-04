

function findNextZero(puzzle, i, j)
{
  let res;
  
  res = {
    i : -1,
    j : -1
  };
  while (++j < puzzle[i].length)
   {
     if (puzzle[i][j] == 0)
      {
        res["i"] = i;
        res["j"] = j;
        return res;
      }
   }
  while(++i < puzzle.length)
  {
     j = -1
     while (++j < puzzle[i].length)
     {
       if (puzzle[i][j] == 0)
       {
         res["i"] = i;
         res["j"] = j;
         return res;
       }
     }
  }
  
  return res;
}

function check(puzzle, i, j, num)
{
  let temp;
  let temp2;
  let min_i;
  let min_j;
  let min_values;
  
  //check horizontal
  temp = -1;
  while(++temp < puzzle[i].length)
  {
    if(puzzle[i][temp] == num)
      return false;
  }
  
  //check vertical
  temp = -1;
  while(++temp < puzzle.length)
  {
    if(puzzle[temp][j] == num)
      return false;
  }
  
  //check 3x3
  min_values = [0, 3, 6]
  min_i = min_values[Math.floor(i / 3)];
  min_j = min_values[Math.floor(j / 3)];
  temp = min_i;
  while(temp < min_i + 3)
  {
    temp2 = min_j;
    while (temp2 < min_j + 3)
     {
        if (puzzle[temp][temp2] == num)
        {
          return false;
        }
        temp2++;
     }
    temp++;
  }
  
  return true;
}

function solve(puzzle, i, j)
{
  let value;
  let nextZeroCords;
  
  value = 0;
  while (++value < 10)
  {
    if (!check(puzzle, i, j, value))
      continue ;
    puzzle[i][j] = value;
    nextZeroCords = findNextZero(puzzle, i, j);
    //console.log("next zero:", nextZeroCords)
    if (nextZeroCords.i == -1)
      return true;
    if (solve(puzzle, nextZeroCords.i, nextZeroCords.j))
    {
      return true;
    }
  }
  puzzle[i][j] = 0;
  return false;
}

function sudoku(puzzle) {
  let i;
  let j;
  
  i = -1;
  while (++i < puzzle.length)
  {
     j = -1;
     while(++j < puzzle[i].length)
     {
       if (puzzle[i][j] == 0)
       {
          solve(puzzle, i, j)
         console.log("puzzle after solve :\n", puzzle)
         return puzzle;
       }
     }
  }
  
  return puzzle;
}
