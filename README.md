# GameAPI

## Note
This is a fork of [scarabcoder GameAPI](https://github.com/scarabcoder/GameAPI).

# Latest: Beta 0.4.1

GameAPI is a plugin-library used for creating minigames in Spigot API.
Simply put, you no longer have to worry about coding common things in minigames like teams 
,arena management, tablists, seperate worlds. It allows the developer to concentrate on the 
minigame itself.

## Arena creation and settings
Every arena can have it's own settings ranging from block destruction enabling, weather, border size and other.
With every update there will be more and more settings.

```Java
//Set the arena, with a string parameter for the world name
Arena myGameArena = new Arena("myworld"); 
//Set the lobby spawn, for pre-game waiting.
myGameArena.setLobbySpawn(arena.getWorld().getSpawnLocation)); 

//Create the game object
Game myGame = new Game("MyGame", myGameArena, MyPlugin.getPlugin());  
//Set the prefix used in messages
myGame.setPrefix("[" + ChatColor.AQUA + "My Game" + ChatColor.RESET + "]"); 

ArenaSettings mySettings = myGameArena.getArenaSettings(); //Get arena settings
mySettings.setCanDestroy(false); //Don't allow block breaking
mySettings.setCanBuild(false); //Don't allow block placing
mySettings.setAllowItemDrop(false); //Don't allow players to drop items
```

## Events
Another excellent feature are events which enable you to have more control over what happens in the arena.
```Java
// GameStartEvent handler
public void onStart(GameStartEvent event){
  // Get all GamePlayers from the started game
  for(GamePlayer player : event.getGame().getPlayers()){
    // Get the Bukkit player from GamePlayer object and send a message
    player.getPlayer().sendMessage("Game started!);
    }
}
```

## API Wiki
There is also a github wiki planned for the API, but release date is TBA.

## Warning 
Some API features contain NMS code which may be buggy and not work on all versions.

Currently fully supported versions: 1.19
