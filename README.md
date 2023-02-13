# GameAPI

# Latest: Release 0.3.0

GameAPI is a plugin-library used for Spigot plugins. 
Simply put, you no longer have to code common things in minigames like teams 
or arena management. It allows the developer to concentrate on the 
minigame itself, with some extra utilities not included in the Spigot API.

## Example
Create and configure a game.
```Java
Arena myGameArena = new Arena("myworld"); //Set the arena, with a string parameter for the world name
myGameArena.setLobbySpawn(arena.getWorld().getSpawnLocation)); //Set the lobby spawn, for pre-game waiting.
	
Game myGame = new Game("MyGame", myGameArena, MyPlugin.getPlugin());  //Create the game object
myGame.setPrefix("[" + ChatColor.AQUA + "My Game" + ChatColor.RESET + "]"); //Set the prefix used in messages

ArenaSettings mySettings = myGameArena.getArenaSettings(); //Get arena settings
mySettings.setCanDestroy(false); //Don't allow block breaking
mySettings.setCanBuild(false); //Don't allow block placing
mySettings.setAllowItemDrop(false); //Don't allow players to drop items
```

ArenaSettings are the tip of the iceberg, however. 
If you wanted to set properties for only a single area, you can define Areas with their own 
set of utility events and ArenaSettings.

For more on how to get started with the GameAPI library, check out the GitHub wiki.
