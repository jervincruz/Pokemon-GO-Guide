/*
 * Utilizes binary search and linear search to display desired pokemon
 */
public class pokeSearch {
	
	public void pokemonSearch(int start, int end, Pokemon [] arr, String pokemon){
		int mid = (start + end) / 2;
		while(start <= end){
			if(arr[mid].name == pokemon){
				break;
			}
			else if(pokemon.compareTo(arr[mid].name) < 0){
				end = mid - 1;
			}
			else{
				start = mid + 1;
			}
			mid = (start + end) / 2;
		}
		if(arr[mid].name.compareTo(pokemon) != 0){
			System.out.print("Pokemon Not Found!");
			return;
		}
		System.out.println("[Name, Type, Capture, Flee, Stamina, Attack, Defense, Candies]");
		arr[mid].printPokemon();
	}
	
	public void typeSearch(Pokemon [] arr, String type){
		for(int i = 0; i < arr.length; i++){
			if(arr[i].type.contains(type)){
				arr[i].printPokemon();
			}
		}
	}
}