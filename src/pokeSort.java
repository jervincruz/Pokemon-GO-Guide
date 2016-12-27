/**
 * Utilizes Quicksort on Pokemon array (pokedex) with the highest index number chosen as the pivot
 */
public class pokeSort {
	// These booleans trigger which Pokemon trait will be sorted upon user input
	boolean name, type, capture, flee, attack, defense, stamina, candies, sortNumber, sortString = false;
	
    int partitionNumber(Pokemon arr[], int low, int high){	
        Pokemon pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<=high-1; j++){
        	// compare currently traversed to pivot (high)
            if (capture == true){
            		if(arr[j].capture <= pivot.capture){
                i++;
                Pokemon temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            	}
            }
            else if(flee == true){
        		if(arr[j].flee <= pivot.flee){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(attack == true){
        		if(arr[j].attack <= pivot.attack){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(defense == true){
        		if(arr[j].defense <= pivot.defense){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(stamina == true){
        		if(arr[j].stamina <= pivot.stamina){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
            else if(candies == true){
        		if(arr[j].candies <= pivot.candies){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
        		}
            }
        }
 
        // swap arr[i+1] with pivot
        Pokemon temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp; 
 
        return i+1;
    }
    
    
    int partitionString(Pokemon arr[], int low, int high){	
        Pokemon pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<=high-1; j++){
        	// if currently traversed is lexicographical less than pivot, swap
        	if(name == true){
            if((arr[j].name).compareTo(pivot.name) <= 0){
                i++;
                Pokemon temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        	}
        	else if(type == true){
                if((arr[j].type).compareTo(pivot.type) <= 0){
                    i++;
                    Pokemon temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        	}
        }
        
	    Pokemon temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp; 
	
	    return i+1;   
    }
	 
	    void sort(Pokemon[] pokedex, int low, int high) 
	    {
	        if (low < high)
	        {
	            // pi = partitioning index
	        	int pi;
	        	pi = partitionNumber(pokedex, low, high);
	            sort(pokedex, low, pi-1);
	            sort(pokedex, pi+1, high);
	        }
	    }
	   
	    void sortString(Pokemon [] pokedex, int low, int high){
	    	if(low < high){
	    		int pi2;
		            // Recursively sort elements before
		            // partition and after partition
	    		pi2 = partitionString(pokedex, low, high);
	            sortString(pokedex, low, pi2-1);
	            sortString(pokedex, pi2+1, high);        
	            }
	    	}

}
