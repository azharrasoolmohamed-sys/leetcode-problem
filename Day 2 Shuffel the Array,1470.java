class Solution {

public int[] shuffle(int[] nums, int n) {

int[] result = new int[2* n];

int index = 0; // pointer for result array

for (int i = 0; i < n; i++) {

result[index] = nums[i];

index++;

result[index] = nums[i + n]; // take y_i from second half

index++;

// take x_1 from first half

}

  return result;
 }
} 
