/**
 * Utilizes Quicksort on Move arrays (quick & charge) with the highest index number chosen as the pivot
 */
public class moveSort {
	// These booleans trigger which Move trait will be sorted upon user input
	boolean name, type, DPS, power, duration, damageWindow = false;
	
    int partitionNumber(Move arr[], int low, int high){	
        Move pivot = arr[high]; 
        int i = (low-1); // low index
        for (int j=low; j<=high-1; j++){
            // compare currently traversed to pivot
            if(DPS == true){
        		if(arr[j].DPS <= pivot.DPS){
                    i++;
                    Move temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(power == true){
        		if(arr[j].power <= pivot.power){
                    i++;
                    Move temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(duration == true){
        		if(arr[j].duration <= pivot.duration){
                    i++;
                    Move temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(damageWindow == true){
        		if(arr[j].damageWindow <= pivot.damageWindow){
                    i++;
                    Move temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
        }
 
        Move temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp; 
 
        return i+1;
    }
       
    int partitionString(Move arr[], int low, int high){	
        Move pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<=high-1; j++)
        {
        	// if currently traversed is lexicographical less than pivot, swap
        	if(name == true){
            if((arr[j].name).compareTo(pivot.name) <= 0){
                i++;
                Move temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        	}
        	else if(type == true){
                if((arr[j].type).compareTo(pivot.type) <= 0){
                    i++;
                    Move temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        	}
        }
        
	    Move temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp; 
	
	    return i+1;   
    }
	 
	    void sort(Move[] moveArr, int low, int high){
	        if (low < high){
	        	 // pi = partitioning index
	        	int pi;
	        	pi = partitionNumber(moveArr, low, high);
	            sort(moveArr, low, pi-1);
	            sort(moveArr, pi+1, high);
	        }
	    }
	   
	void sortString(Move [] moveArr, int low, int high){		
		if(low < high){
		int pi2;
		            // Recursively sort elements before
		            // partition and after partition
	             pi2 = partitionString(moveArr, low, high);
	             sortString(moveArr, low, pi2-1);
	             sortString(moveArr, pi2+1, high);        
	            }
		}

}
