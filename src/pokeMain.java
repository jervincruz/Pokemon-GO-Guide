import java.util.HashMap;
import java.util.Scanner;

/* @Objective: Pokemon GO Guide: 
 * 			   1) Categorizes Pokemon based on 8 different characteristics
 * 			   2) Search Pokemon by name or type
 * 			   3) Categorizes in-game moves based on 6 different characteristics
 * @author: Jervin Cruz
 * 
 * Credits to @TheSilphRoad for Pokemon database
 */
public class pokeMain {
	static int NUM_OF_POKEMON = 151;
	static int NUM_OF_QUICK_MOVES = 41;
	static int NUM_OF_CHARGE_MOVES = 92;
	static Pokemon [] pokedex = new Pokemon[NUM_OF_POKEMON];
	static Move [] quick = new Move[NUM_OF_QUICK_MOVES];
	static Move [] charge = new Move[NUM_OF_CHARGE_MOVES];

	public static void main(String[] args) {
		pokeSort sort = new pokeSort();
		pokeSearch search = new pokeSearch();
		moveSort sortMoves = new moveSort();

		/** Create 151 Pokemon (name, type, capture, flee, stamina, attack, defense, candies) **/
		
		pokedex[0] = new Pokemon("Bulbasaur", "Grass/Poison", 16, 10, 90, 126, 126, 25);
		pokedex[1] = new Pokemon("Ivysaur", "Grass/Poison", 8, 7, 120, 156, 158, 100);
		pokedex[2] = new Pokemon("Venasaur", "Grass/Poison", 4, 5, 160, 198, 200, 25);
		pokedex[3] = new Pokemon("Charmander", "Fire", 16, 10, 78, 128, 108, 25);
		pokedex[4] = new Pokemon("Charmeleon", "Fire", 8, 7, 116, 160, 140, 100);
		pokedex[5] = new Pokemon("Charizard", "Fire/Flying", 4, 5, 156, 212, 182, 0);
		pokedex[6] = new Pokemon("Squirtle", "Water", 16, 10, 88, 112, 142, 25);
		pokedex[7] = new Pokemon("Wartortle", "Water", 8, 7, 118, 144, 176, 100);
		pokedex[8] = new Pokemon("Blastoise", "Water", 4, 5, 158, 186, 222, 0);
		pokedex[9] = new Pokemon("Caterpie", "Bug", 40, 20, 90, 62, 66, 12);
		pokedex[10] = new Pokemon("Metapod", "Bug", 20, 9, 100, 56, 86, 50);
		pokedex[11] = new Pokemon("Butterfree", "Bug/Flying", 10, 6, 120, 144, 144, 0);
		pokedex[12] = new Pokemon("Weedle", "Bug/Poison", 40, 20, 80, 68, 64, 12);
		pokedex[13] = new Pokemon("Kakuna", "Bug/Poison", 20, 9, 90, 62, 82, 50);
		pokedex[14] = new Pokemon("Beedril", "Bug/Poison", 10, 6, 130, 144, 130, 0);
		pokedex[15] = new Pokemon("Pidgey", "Normal/Flying", 40, 20, 80, 94, 90, 12);
		pokedex[16] = new Pokemon("Pidgeotto", "Normal/Flying", 20, 9, 126, 126, 122, 50);
		pokedex[17] = new Pokemon("Pidgeot", "Normal/Flying", 10, 6, 166, 170, 166, 0);
		pokedex[18] = new Pokemon("Rattata", "Normal", 40, 20, 60, 92, 86, 25);
		pokedex[19] = new Pokemon("Raticate", "Normal", 16, 7, 110, 146, 150, 0);
		pokedex[20] = new Pokemon("Spearow", "Normal/Flying", 40, 15, 80, 102, 78, 50);
		pokedex[21] = new Pokemon("Fearow", "Normal/Flying", 16, 7, 130, 168, 146, 0);
		pokedex[22] = new Pokemon("Ekans", "Poison", 40, 15, 70, 112, 112, 50);
		pokedex[23] = new Pokemon("Arbok", "Poison", 16, 7, 120, 166, 166, 0);
		pokedex[24] = new Pokemon("Pikachu", "Electric", 16, 10, 70, 124, 108, 50);
		pokedex[25] = new Pokemon("Raichu", "Electric", 8, 6, 120, 200, 154, 0);
		pokedex[26] = new Pokemon("Sandshrew", "Ground", 40, 10, 100, 90, 114, 50);
		pokedex[27] = new Pokemon("Sandslash", "Ground", 16, 6, 150, 150, 172, 0);
		pokedex[28] = new Pokemon("Nidoran (Female)", "Poison", 40, 15, 110, 100, 104, 25);
		pokedex[29] = new Pokemon("Nidirona", "Poison", 20, 7, 140, 132, 136, 100);
		pokedex[30] = new Pokemon("Nidoqueen", "Poison/Ground", 10, 5, 180, 184, 190, 0);
		pokedex[31] = new Pokemon("Nidoran (Male)", "Poison", 40, 15, 92, 110, 94, 25);
		pokedex[32] = new Pokemon("Nidorino", "Poison", 20, 7, 122, 142, 128, 100);
		pokedex[33] = new Pokemon("Nidoking", "Poison/Ground", 10, 5, 162, 204, 170, 0);
		pokedex[34] = new Pokemon("Clefairy", "Fairy", 24, 10, 140, 116, 124, 50);
		pokedex[35] = new Pokemon("Clefable", "Fairy", 8, 6, 190, 178, 178, 0);
		pokedex[36] = new Pokemon("Vulpix", "Fire", 24, 10, 76, 106, 118, 50);
		pokedex[37] = new Pokemon("Ninetales", "Fire", 8, 6, 146, 176, 194, 0);
		pokedex[38] = new Pokemon("Jigglypuff", "Normal/Fairy", 40, 10, 230, 98, 54, 50);
		pokedex[39] = new Pokemon("Wigglytuff", "Normal/Fairy", 16, 6, 280, 168, 108, 0);
		pokedex[40] = new Pokemon("Zubat", "Poison/Flying", 40, 20, 80, 88, 90, 50);
		pokedex[41] = new Pokemon("Golbat", "Poison/Flying", 16, 7, 150, 164, 164, 0);
		pokedex[42] = new Pokemon("Oddish", "Grass/Poison", 48, 15, 90, 134, 130, 25);
		pokedex[43] = new Pokemon("Gloom", "Grass/Poison", 24, 7, 120, 162, 158, 100);
		pokedex[44] = new Pokemon("Vileplume", "Grass/Poison", 12, 5, 150, 202, 190, 0);
		pokedex[45] = new Pokemon("Paras", "Bug/Grass", 32, 15, 70, 122, 120, 50);
		pokedex[46] = new Pokemon("Parasect", "Bug/Grass", 16, 7, 120, 162, 170, 0);
		pokedex[47] = new Pokemon("Venonat", "Bug/Poison", 40, 15, 120, 108, 118, 50);
		pokedex[48] = new Pokemon("Venomoth", "Bug/Poison", 16, 7, 140, 172, 154, 0);
		pokedex[49] = new Pokemon("Diglett", "Ground", 40, 10, 20, 108, 86, 50);
		pokedex[50] = new Pokemon("Dugtrio", "Ground", 16, 6, 70, 148, 140, 0);
		pokedex[51] = new Pokemon("Meowth", "Normal", 40, 15, 80, 104, 94, 50);
		pokedex[52] = new Pokemon("Persian", "Normal", 16, 7, 130, 156, 146, 0);
		pokedex[53] = new Pokemon("Psyduck", "Water", 40, 10, 100, 132, 112, 50);
		pokedex[54] = new Pokemon("Golduck", "Water", 16, 6, 160, 194, 176, 0);
		pokedex[55] = new Pokemon("Mankey", "Fighting", 40, 10, 80, 122, 96, 50);
		pokedex[56] = new Pokemon("Primeape", "Fighting", 16, 6, 130, 178, 150, 0);
		pokedex[57] = new Pokemon("Growlithe", "Fire", 24, 10, 110, 156, 110, 50);
		pokedex[58] = new Pokemon("Arcanine", "Fire", 8, 6, 180, 230, 180, 0);
		pokedex[59] = new Pokemon("Poliwag", "Water", 40, 15, 80, 108, 98, 25);
		pokedex[60] = new Pokemon("Poliwhirl", "Water", 20, 7, 130, 132, 132, 100);
		pokedex[61] = new Pokemon("Polywrath", "Water/Fighting", 10, 5, 180, 180, 202, 0);
		pokedex[62] = new Pokemon("Abra", "Psychic", 40, 99, 50, 110, 76, 25);
		pokedex[63] = new Pokemon("Kadabra", "Psychic", 20, 7, 80, 150, 112, 100);
		pokedex[64] = new Pokemon("Alakazam", "Psychic", 10, 5, 110, 186, 152, 0);
		pokedex[65] = new Pokemon("Machop", "Fighting", 40, 10, 140, 118, 96, 25);
		pokedex[66] = new Pokemon("Machoke", "Fighting", 20, 7, 160, 154, 144, 100);
		pokedex[67] = new Pokemon("Machamp", "Fighting", 10, 5, 180, 198, 180, 0);
		pokedex[68] = new Pokemon("Bellsprout", "Grass/Poison", 40, 15, 100, 158, 78, 25);
		pokedex[69] = new Pokemon("Weepinbell", "Grass/Poison", 20, 7, 130, 190, 110, 100);
		pokedex[70] = new Pokemon("Victreebell", "Grass/Poison", 10, 5, 160, 222, 152, 0);
		pokedex[71] = new Pokemon("Tentacool", "Water/Poison", 40, 15, 80, 106, 136, 50);
		pokedex[72] = new Pokemon("Tentacruel", "Water/Poison", 16, 7, 160, 170, 196, 0);
		pokedex[73] = new Pokemon("Geodude", "Rock/Ground", 40, 10, 80, 106, 118, 25);
		pokedex[74] = new Pokemon("Graveler", "Rock/Ground", 20, 7, 110, 142, 156, 100);
		pokedex[75] = new Pokemon("Golem", "Rock/Ground", 10, 5, 160, 176, 198, 0);
		pokedex[76] = new Pokemon("Ponyta", "Fire", 32, 10, 100, 168, 138, 50);
		pokedex[77] = new Pokemon("Rapidash", "Fire", 12, 6, 130, 200, 170, 0);
		pokedex[78] = new Pokemon("Slowpoke", "Water/Psychic", 40, 10, 180, 110, 110, 50);
		pokedex[79] = new Pokemon("Slowbro", "Water/Psychic", 16, 6, 190, 184, 198, 0);
		pokedex[80] = new Pokemon("Magnemite", "Electric/Steel", 40, 10, 50, 128, 138, 50);
		pokedex[81] = new Pokemon("Magneton", "Eletric/Steel", 16, 6, 100, 186, 180, 0);
		pokedex[82] = new Pokemon("Farfetchd", "Normal/Flying", 24, 9, 104, 138, 132, 0);
		pokedex[83] = new Pokemon("Doduo", "Normal/Flying", 40, 10, 70, 126, 96, 50);
		pokedex[84] = new Pokemon("Dodrio", "Normal/Flying", 16, 6, 120, 182, 150, 0);
		pokedex[85] = new Pokemon("Seel", "Water", 40, 9, 130, 104, 138, 50);
		pokedex[86] = new Pokemon("Dewgong", "Water/Ice", 16, 6, 180, 156, 192, 0);
		pokedex[87] = new Pokemon("Grimer", "Poison", 40, 10, 160, 124, 110, 50);
		pokedex[88] = new Pokemon("Muk", "Poison", 16, 6, 210, 180, 188, 0);
		pokedex[89] = new Pokemon("Shellder", "Water", 40, 10, 60, 120, 212, 50);
		pokedex[90] = new Pokemon("Cloyster", "Water/Ice", 16, 6, 100, 196, 196, 0);
		pokedex[91] = new Pokemon("Gastly", "Ghost/Poison", 32, 10, 60, 136, 82, 25);
		pokedex[92] = new Pokemon("Haunter", "Ghost/Poison", 16, 7, 90, 172, 118, 100);
		pokedex[93] = new Pokemon("Gengar", "Ghost/Poison", 8, 5, 120, 204, 156, 0);
		pokedex[94] = new Pokemon("Onix", "Rock/Ground", 16, 9, 70, 90, 186, 0);
		pokedex[95] = new Pokemon("Drowzee", "Psychic", 40, 10, 120, 104, 140, 50);
		pokedex[96] = new Pokemon("Hypno", "Psychic", 16, 6, 170, 162, 196, 0);
		pokedex[97] = new Pokemon("Krabby", "Water", 40, 15, 60, 116, 110, 50);
		pokedex[98] = new Pokemon("Kingler", "Water", 16, 7, 110, 178, 168, 0);
		pokedex[99]	= new Pokemon("Voltorb", "Electric", 40, 10, 80, 102, 124, 50);
		pokedex[100] = new Pokemon("Electrode", "Electric", 16, 6, 120, 150, 174, 0);
		pokedex[101] = new Pokemon("Exeggcute", "Grass/Psychic", 40, 10, 120, 110, 132, 50);
		pokedex[102] = new Pokemon("Exeggutor", "Grass/Psychic", 16, 6, 190, 232, 164, 0);
		pokedex[103] = new Pokemon("Cubone", "Ground", 32, 10, 100, 102, 150, 50);
		pokedex[104] = new Pokemon("Marowak", "Ground", 12, 6, 120, 140, 202, 0);
		pokedex[105] = new Pokemon("Hitmonlee", "Fighting", 16, 9, 100, 148, 172, 0);
		pokedex[106] = new Pokemon("Hitmonchan", "Fighting", 16, 9, 100, 138, 204, 0);
		pokedex[107] = new Pokemon("Lickitung", "Normal", 16, 9, 180, 126, 160, 0);
		pokedex[108] = new Pokemon("Koffing","Poison", 40, 10, 80, 136, 142, 50);
		pokedex[109] = new Pokemon("Weezing", "Poison", 16, 6, 130, 90, 198, 0);
		pokedex[110] = new Pokemon("Rhyhorn", "Ground/Rock", 40, 10, 160, 110, 116, 50);
		pokedex[111] = new Pokemon("Rhydon", "Ground/Rock", 16, 6, 210, 166, 160, 0);
		pokedex[112] = new Pokemon("Chansey", "Normal", 16, 9, 500, 40, 60, 0);
		pokedex[113] = new Pokemon("Tangela", "Grass", 32, 9, 130, 164, 152, 0);
		pokedex[114] = new Pokemon("Kangaskhan", "Normal", 16, 9, 210, 142, 178, 0);
		pokedex[115] = new Pokemon("Horsea", "Water", 40, 10, 60, 122, 100, 50);
		pokedex[116] = new Pokemon("Seadra", "Water", 16, 6, 110, 176, 150, 0);
		pokedex[117] = new Pokemon("Goldeen", "Water", 40, 15, 90, 112, 126, 50);
		pokedex[118] = new Pokemon("Seaking", "Water", 16, 7, 160, 172, 160, 0);
		pokedex[119] = new Pokemon("Staryu", "Water", 40, 15, 60, 130, 128, 50);
		pokedex[120] = new Pokemon("Starmie", "Water", 16, 6, 120, 194, 192, 0);
		pokedex[121] = new Pokemon("Mr. Mime", "Psychic/Fairy", 24, 9, 80, 154, 196, 0);
		pokedex[122] = new Pokemon("Scyther", "Bug/Flying", 24, 9, 140, 176, 180, 0);
		pokedex[123] = new Pokemon("Jynx", "Ice/Psychic", 24, 9, 130, 172, 134, 0);
		pokedex[124] = new Pokemon("Electabuzz", "Electric", 24, 9, 130, 198, 160, 0);
		pokedex[125] = new Pokemon("Magmar", "Fire", 24, 9, 130, 214, 158, 0);
		pokedex[126] = new Pokemon("Pinsir", "Bug", 24, 9, 130, 184, 186, 0);
		pokedex[127] = new Pokemon("Tauros", "Normal", 24, 9, 150, 148, 184, 0);
		pokedex[128] = new Pokemon("Magikarp", "Water", 56, 15, 40, 42, 84, 400);
		pokedex[129] = new Pokemon("Gyarados", "Water/Flying", 8, 7, 190, 192, 196, 0);
		pokedex[130] = new Pokemon("Lapras", "Water/Ice", 16, 9, 260, 186, 190, 0);
		pokedex[131] = new Pokemon("Ditto", "Normal", 16, 10, 96, 110, 110, 0);
		pokedex[132] = new Pokemon("Eevee", "Normal", 32, 10, 110, 114, 128, 25);
		pokedex[133] = new Pokemon("Vaporeon", "Water", 12, 6, 260, 186, 168, 0);
		pokedex[134] = new Pokemon("Jolteon", "Electric", 12, 6, 130, 192, 174, 0);
		pokedex[135] = new Pokemon("Flareon", "Fire", 12, 6, 130, 238, 178, 0);
		pokedex[136] = new Pokemon("Porygon", "Normal", 32, 9, 130, 156, 158, 0);
		pokedex[137] = new Pokemon("Omanyte", "Rock/Water", 32, 9, 70, 132, 160, 0);
		pokedex[138] = new Pokemon("Omastar", "Rock/Water", 12, 5, 140, 180, 202, 0);
		pokedex[139] = new Pokemon("Kabuto", "Rock/Water", 32, 9, 60, 148, 142, 50);
		pokedex[140] = new Pokemon("Kabutops", "Rock/Water", 12, 5, 120, 190, 190, 0);
		pokedex[141] = new Pokemon("Aerodactyl", "Rock/Flying", 16, 9, 160, 182, 162, 0);
		pokedex[142] = new Pokemon("Snorlax", "Normal", 16, 9, 320, 180, 180, 0);
		pokedex[143] = new Pokemon("Articuno", "Ice/Flying", 0, 10, 180, 198, 242, 0);
		pokedex[144] = new Pokemon("Zapdos", "Electric/Flying", 0, 10, 180, 232, 194, 0);
		pokedex[145] = new Pokemon("Moltres", "Fire/Flying", 0, 10, 180, 242, 194, 0);
		pokedex[146] = new Pokemon("Dratini", "Dragon", 32, 9, 82, 128, 110, 25);
		pokedex[147] = new Pokemon("Dragonair", "Dragon", 8, 6, 122, 170, 152, 100);
		pokedex[148] = new Pokemon("Dragonite", "Dragon/Flying", 4, 5, 182, 250, 212, 0);
		pokedex[149] = new Pokemon("Mewtwo", "Psychic", 0, 10, 212, 284, 202, 0);
		pokedex[150] = new Pokemon("Mew", "Psychic", 0, 10, 200, 220, 220, 0);

		/** QUICK Moves (Name, Type, DPS, Power, Duration (MS), Damage Window) **/
		
		quick[0] = new Move("Pound", "Normal", 12.96, 7, 540, 200);
		quick[1] = new Move("Metal Claw", "Steel", 12.7, 8, 630, 200);
		quick[2] = new Move("Psycho Cut", "Psychic", 12.28, 7, 570, 200);
		quick[3] = new Move("Scratch", "Normal", 12, 6, 500, 200);
		quick[4] = new Move("Water Gun", "Water", 12, 6, 500, 200);
		quick[5] = new Move("Wing Attack", "Flying", 12, 9, 750, 200);
		quick[6] = new Move("Bite", "Dark", 12, 6, 500, 200);
		quick[7] = new Move("Dragon Breath", "Dragon", 12, 6, 500, 200);
		quick[8] = new Move("Fire Fang", "Fire", 11.9, 10, 840, 200);
		quick[9] = new Move("Shadow Claw", "Ghost", 11.58, 11, 950, 200);
		quick[10] = new Move("Feint Attack", "Dark", 11.54, 12, 1040, 200);
		quick[11] = new Move("Poison Jab", "Poison", 11.43, 12, 1050, 200);
		quick[12] = new Move("Zen Headbutt", "Psychic", 11.43, 12, 1050, 200);
		quick[13] = new Move("Steel Wing", "Steel", 11.28, 15, 1330, 200);
		quick[14] = new Move("Frost Breath", "Ice", 11.11, 9, 810, 200);
		quick[15] = new Move("Bug Bite", "Bug", 11.11, 5, 450, 200);
		quick[16] = new Move("Mud Slap", "Ground", 11.11, 15, 1350, 200);
		quick[17] = new Move("Tackle", "Normal", 10.91, 12, 1100, 200);
		quick[18] = new Move("Mud Shot", "Ground", 10.91, 6, 550, 200);
		quick[19] = new Move("Bubble", "Water", 10.87, 25, 2300, 200);
		quick[20] = new Move("Vine Whip", "Grass", 10.77, 7, 650, 200);
		quick[21] = new Move("Ice Shard", "Ice", 10.71, 15, 1400, 200);
		quick[22] = new Move("Rock Smash", "Fighting", 10.64, 15, 1410, 200);
		quick[23] = new Move("Cut", "Normal", 10.62, 12, 1130, 200);
		quick[24] = new Move("Poison Sting", "Poison", 10.43, 6, 575, 200);
		quick[25] = new Move("Razor Leaf", "Grass", 10.34, 15, 1450, 200);
		quick[26] = new Move("Lick", "Ghost", 10, 5, 500, 200);
		quick[27] = new Move("Sucker Punch", "Dark", 10, 7, 700, 200);
		quick[28] = new Move("Spark", "Electric", 10, 7, 700, 200);
		quick[29] = new Move("Confusion", "Psychic", 9.93, 15, 1510, 200);
		quick[30] = new Move("Acid", "Poison", 9.52, 10, 1050, 200);
		quick[31] = new Move("Ember", "Fire", 9.52, 10, 1050, 200);
		quick[32] = new Move("Rock Throw", "Rock", 8.82, 12, 1360, 200);
		quick[33] = new Move("Peck", "Flying", 8.7, 10, 1150, 200);
		quick[34] = new Move("Thunder Shock", "Electric", 8.33, 5, 600, 200);
		quick[35] = new Move("Bullet Punch", "Steel", 8.33, 10, 1200, 200);
		quick[36] = new Move("Low Kick", "Fighting", 8.33, 5, 600, 200);
		quick[37] = new Move("Quick Attack", "Normal", 7.52, 10, 1330, 200);
		quick[38] = new Move("Karate Chop", "Fighting", 7.5, 6, 800, 200);
		quick[39] = new Move("Fury Cutter", "Bug", 7.5, 3, 400, 200);
		quick[40] = new Move("Splash", "Water", 0, 0, 1230, 200);		
		
		/** CHARGE Moves (Name, Type, Dsort, Power, Duration (MS), Damage Window) **/
		
		charge[0] = new Move("Cross Chop", "Fighting", 30, 60, 2000, 300);
		charge[1] = new Move("Stone Edge", "Rock", 25.81, 80, 3100, 400);
		charge[2] = new Move("Blizzard", "Ice", 25.64, 100, 3900, 0);
		charge[3] = new Move("Body Slam", "Normal", 25.64, 40, 1560, 200);
		charge[4] = new Move("Power Whip", "Grass", 25, 70, 2800, 1300);
		charge[5] = new Move("Hurricane", "Flying", 25, 80, 3200, 1770);
		charge[6] = new Move("Megahorn", "Bug", 25, 80, 3200, 300);
		charge[7] = new Move("Solar Beam", "Grass", 24.49, 120, 4900, 1700);
		charge[8] = new Move("FireBlast", "Fire", 24.39, 100, 4100, 400);
		charge[9] = new Move("Hyper Beam", "Normal", 24, 120, 5000, 800);
		charge[10] = new Move("Earthquake", "Ground", 23.81, 100, 4200, 1950);
		charge[11] = new Move("Hydro Pump", "Water", 23.68, 90, 3800, 2100);
		charge[12] = new Move("Dragon Claw", "Dragon", 23.33, 35, 1500, 200);
		charge[13] = new Move("Thunder", "Electric", 23.26, 100, 4300, 1550);
		charge[14] = new Move("Gunk Shot", "Poison", 21.67, 65, 3000, 400);
		charge[15] = new Move("Sludge Bomb", "Poison", 21.15, 55, 2600, 500);
		charge[16] = new Move("Heat Wave", "Fire", 21.05, 80, 3800, 400);
		charge[17] = new Move("Moonblast", "Fairy", 20.73, 85, 4100, 600);
		charge[18] = new Move("Sludgewave", "Poison", 20.59, 70, 3400, 900);
		charge[19] = new Move("Thunderbolt", "Electric", 20.37, 55, 2700, 800);
		charge[20] = new Move("Petal Blizzard", "Grass", 20.31, 65, 3200, 1000);
		charge[21] = new Move("Leaf Blade", "Grass", 19.64, 55, 2800, 1000);
		charge[21] = new Move("Psychic", "Psychic", 19.64, 55, 2800, 1200);
		charge[22] = new Move("PsyStrike", "Psychic", 19.61, 45, 2350, 200);
		charge[23] = new Move("Aqua Tail", "Water", 19.15, 45, 2350, 200);
		charge[24] = new Move("Flamethrower", "Fire", 18.97, 55, 2900, 900);
		charge[25] = new Move("Play Rough", "Fairy", 18.97, 55, 2900, 1300);
		charge[26] = new Move("Brick Break", "Fighting", 18.75, 30, 1600, 400);
		charge[27] = new Move("Dragon Pulse", "Dragon", 18.06, 65, 3600, 1200);
		charge[28] = new Move("Ice Beam", "Ice", 17.81, 65, 3600, 1200);
		charge[29] = new Move("Bug Buzz", "Bug", 17.65, 75, 4250, 1500);
		charge[30] = new Move("Thunder Punch", "Electric", 16.67, 40, 2400, 250);
		charge[31] = new Move("Seed Bomb", "Grass", 16.67, 40, 2400, 500);
		charge[32] = new Move("Cross Poison", "Poison", 16.67, 25, 1500, 300);
		charge[33] = new Move("X Scissor", "Bug", 16.67, 35, 2100, 250);
		charge[34] = new Move("Hyper Fang", "Normal", 16.67, 35, 2100, 300);
		charge[35] = new Move("Rest", "Psychic", 16.13, 50, 3100, 1296);
		charge[36] = new Move("Bone Club", "Ground", 15.63, 25, 1600, 250);
		charge[37] = new Move("Rock Slide", "Rock", 15.63, 50, 3200, 1400);
		charge[38] = new Move("Flash Cannon", "Steel", 15.38, 60, 3900, 1100);
		charge[39] = new Move("Iron Head", "Steel", 15, 30, 2000, 250);
		charge[40] = new Move("Drill Peck", "Flying", 14.81, 40, 2700, 900);
		charge[41] = new Move("Psyshock", "Psychic", 14.81, 40, 2700, 500);
		charge[42] = new Move("Drill Run", "Ground", 14.71, 50, 3400, 700);
		charge[43] = new Move("Shadow Ball", "Ghost", 14.61, 45, 3080, 300);
		charge[44] = new Move("Signal Beam", "Bug", 14.52, 45, 3100, 1000);
		charge[45] = new Move("Flame Burst", "Fire", 14.29, 30, 2100, 400);
		charge[46] = new Move("Stomp", "Normal", 14.29, 30, 2100, 700);
		charge[47] = new Move("Fire Punch", "Fire", 14.29, 40, 2800, 510);
		charge[48] = new Move("Submission", "Fighting", 14.29, 30, 2100, 150);
		charge[49] = new Move("Discharge", "Electric", 14, 35, 2500, 700);
		charge[50] = new Move("Giga Drain", "Grass", 13.89, 50, 3600, 1150);
		charge[51] = new Move("Power Gem", "Rock", 13.79, 40, 2900, 800);
		charge[52] = new Move("Scald", "Water", 13.75, 55, 4000, 2100);
		charge[53] = new Move("Low Sweep", "Fighting", 13.33, 30, 2250, 150);
		charge[54] = new Move("Dazzling Gleam", "Fairy", 13.1, 55, 4200, 800);
		charge[55] = new Move("Ice Punch", "Ice", 12.86, 45, 3500, 1100);
		charge[56] = new Move("Dark Pulse", "Dark", 12.86, 45, 3500, 1100);
		charge[57] = new Move("Dig", "Ground", 12.07, 70, 580, 400);
		charge[58] = new Move("Vice Grip", "Normal", 11.9, 25, 2100, 250);
		charge[59] = new Move("Shadow Punch", "Ghost", 11.9, 25, 2100, 300);
		charge[60] = new Move("Parabolic Charge", "Electric", 11.9, 25, 2100, 400);
		charge[61] = new Move("Sludge", "Poison", 11.54, 30, 2600, 500);
		charge[62] = new Move("Mud Bomb", "Ground", 11.54, 30, 2600, 450);
		charge[63] = new Move("Horn Attack", "Normal", 11.36, 25, 2200, 300);
		charge[64] = new Move("Night Slash", "Dark", 11.11, 30, 2700, 200);
		charge[65] = new Move("Magnet Bomb", "Steel", 10.71, 30, 2800, 550);
		charge[66] = new Move("Aqua Jet", "Water", 10.64, 25, 2350, 400);
		charge[67] = new Move("Water Pulse", "Water", 10.61, 35, 3300, 1000);
		charge[68] = new Move("Psybeam", "Psychic", 10.53, 40, 3800, 1300);
		charge[69] = new Move("Poison Fang", "Poison", 10.42, 25, 2400, 200);
		charge[70] = new Move("Brine", "Water", 10.42, 25, 2400, 350);
		charge[71] = new Move("Bubble Beam", "Water", 10.34, 30, 2900, 200);
		charge[72] = new Move("Aerial Ace", "Flying", 10.34, 30, 2900, 600);
		charge[73] = new Move("Bulldoze", "Ground", 10.29, 35, 3400, 1100);
		charge[74] = new Move("Swift", "Normal", 10, 30, 3000, 500);
		charge[75] = new Move("Heart Stamp", "Psychic", 9.8, 25, 2550, 300);
		charge[76] = new Move("Ancient Power", "Rock", 9.72, 35, 3600, 350);
		charge[77] = new Move("Ominous Wind", "Ghost", 9.68, 30, 3100, 250);
		charge[78] = new Move("Twister", "Dragon", 9.26, 25, 2700, 1750);
		charge[79] = new Move("Air Cutter", "Flying", 9.09, 30, 3300, 900);
		charge[80] = new Move("Draining Kiss", "Fairy", 8.93, 25, 2800, 100);
		charge[81] = new Move("Struggle", "Normal", 8.85, 15, 1695, 700);
		charge[82] = new Move("Rock Tomb", "Rock", 8.82, 30, 3400, 900);
		charge[83] = new Move("Flame Wheel", "Fire", 8.7, 40, 4600, 500);
		charge[84] = new Move("Shadow Sneak", "Ghost", 8.06, 25, 3100, 600);
		charge[85] = new Move("Flame Charge", "Fire", 8.06, 25, 3100, 200);
		charge[86] = new Move("Mega Drain", "Grass", 7.81, 25, 3200, 1200);
		charge[87] = new Move("Wrap Pink", "Grass", 6.76, 25, 3700, 1000);
		charge[88] = new Move("Wrap Green", "Grass", 6.76, 25, 3700, 1000);
		charge[89] = new Move("Icy Wind", "Ice", 6.58, 25, 3800, 700);
		charge[90] = new Move("Disarming Voice", "Fairy", 6.41, 25, 3900, 1800);
		charge[91] = new Move("Wrap", "Normal", 6.25, 25, 4000, 600);
		
		/************************************/
		/***	Program Functionality	  ***/
		/************************************/
		
		System.out.println(" --- POKEMON BEGINNERS GUIDE --- \n Enter a selection from the menu:"
				+ "\n1. Sort Pokemon"
				+ "\n2. Search Pokemon"
				+ "\n3. Sort Moves [Gym Effectiveness]"
				+ "\n4. CP Evolution Calculator [In Progress]"
				+ "\n5. Tips & Tricks [In Progress]");
		
		Scanner in = new Scanner(System.in);
		int firstSelection = in.nextInt();
		// Get correct user input
		while(firstSelection > 5 || firstSelection < 1){
			System.out.println("Wrong Entry! Enter a menu input from 1-5: ");
			firstSelection = in.nextInt();
		}
		switch(firstSelection){
		case 1:
		   System.out.println("\t1. Name\n"
							+ "\t2. Type\n"
							+ "\t3. Easiest to Capture\n"
							+ "\t4. Most Likely to Flee\n"
							+ "\t5. Best Stamina\n"
							+ "\t6. Best Attacker\n"
							+ "\t7. Best Defense\n"
							+ "\t8. Candies to Evolve");
			
				/** [Activities in Sort Pokemon] **/
				int secondSelection = in.nextInt();
				switch(secondSelection){
				case 1 : sort.name = true;
						 sort.sortString(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				case 2 :sort.type = true;
				 		sort.sortString(pokedex, 0, NUM_OF_POKEMON - 1);	
					 		for(int j = 0; j < NUM_OF_POKEMON; j++){
							pokedex[j].printPokemon();
					 		}
				 			break;
				case 3 : sort.capture = true; 
						 sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				case 4 : sort.flee = true;
						 sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;						 
				case 5 : sort.stamina = true;
						 sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				case 6 : sort.attack = true;
					  	 sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				case 7 : sort.defense = true;
					     sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				case 8 :
						 sort.candies = true;
						 sort.sortNumber = true;
						 sort.sort(pokedex, 0, NUM_OF_POKEMON - 1);	
							for(int j = 0; j < NUM_OF_POKEMON; j++){
								pokedex[j].printPokemon();
							}
							break;
				}
				break;
		case 2:
			System.out.println("Search Pokemon by:\n"
				+ "1. Name\n"
				+ "2. Type\n");
			int searchName = in.nextInt();
			/** [Activities in Search Pokemon] **/
				  switch(searchName){
				  case 1: // Searches Pokemon Name
					  sort.name = true;
					  sort.sortString(pokedex, 0, NUM_OF_POKEMON - 1); // sort by name first for binary search
					  System.out.println("Enter a pokemon name to get information: ");
					  String pokemonSearched = in.next();
					  search.pokemonSearch(0, NUM_OF_POKEMON - 1, pokedex, pokemonSearched);
					  break;
				  case 2: // Searches Pokemon Type
					  System.out.println("Enter a type to display all pokemon of said type (Water, Fire, Psychic, etc.): ");
					  String typeSearched = in.next();
					  search.typeSearch(pokedex, typeSearched);
				  } 			  				  
		case 3: System.out.println("[Gym Effectiveness] Sort Moves By:\n"
				+ "1. Name\n" 
				+ "2. Type\n"
				+ "3. DPS\n"
				+ "4. Power\n"
				+ "5. Duration\n"
				+ "6. Damage Window");
				int moveSelection;
				moveSelection = in.nextInt();
				switch(moveSelection){
				case 1: sortMoves.name = true;
						sortMoves.sortString(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sortString(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
						break;
				case 2: sortMoves.type = true;
						sortMoves.sortString(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sortString(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
						break;
				case 3: sortMoves.DPS = true;
						sortMoves.sort(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sort(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
				case 4: sortMoves.power = true;
						sortMoves.sort(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sort(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
				case 5: sortMoves.duration = true;
						sortMoves.sort(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sort(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
				case 6: sortMoves.damageWindow = true;
						sortMoves.sort(quick, 0, NUM_OF_QUICK_MOVES - 1);
						sortMoves.sort(charge, 0, NUM_OF_CHARGE_MOVES - 1);
						System.out.println("--- QUICK MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_QUICK_MOVES; j++){
							quick[j].printMove();
						}
						System.out.println("--- CHARGE MOVES ---");
						System.out.println("[Name, Type, DPS, Power, Duration, Damage Window]");
						for(int j = 0; j < NUM_OF_CHARGE_MOVES; j++){
							charge[j].printMove();
						}
						break;
				}
		case 4: 
			System.out.println("Being built! Check github.com/jervincruz for further updates");
			break;
		case 5: 
			System.out.println("Being built! Check github.com/jervincruz for further updates");
			break;
		}	
	}	
}
