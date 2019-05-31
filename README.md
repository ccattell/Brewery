<p>Plugin originally written and coded by DieReicheErethons</p>
<p>
	This Plugin works with Craftbukkit and Spigot 1.13.x, 1.12.x, 1.11.x, 1.10.x, 1.9.x, 1.8.x, 1.7.x, 1.6.x and probably lower.
</p>
<p>
The somewhat difficult brewing process rewards you with a diversity of Potions, which, through their effects, create a drunkeness that has never existed in Minecraft before.
</p>
<p>
Learn the art of brewing through fermenting, distilling and barrel aging on your Minecraft server. Experience how, from spring water and wheat, through hard work, a cool beer is created. Distill high-proof liquor, which gets that unique taste after some aging in oak barrels.
</p>
<p>
Celebrate the biggest feasts you can imagine and always keep the cheerful atmosphere. Fill the taverns with laughter and loud music, while the drunkards scuffle on the streets.
</p>
<h2>Features</h2>
<ul>
	<li>Brew alcoholic Drinks, that actually can make you drunk</li>
	<li>Drunk people will stagger, the chat is influenced, effects and more</li>
	<li>Wake up at /home after a long night of drinking</li>
	<li>Lower quality brewed drinks have downsides like hangover</li>
	<li>Process of brewing with different steps like fermenting, distilling, aging</li>
	<li>Refine the quality, until the Drinks are perfect</li>
	<li>Master the brewing of even the most difficult Drinks</li>
	<li>Create your own Recipes including ingredients, properties and creation process</li>
	<li>Configurable influence on the chat</li>
</ul>

<!--Check the Wiki for more Information on how to install and use Brewery.-->
<h2>Getting Started</h2>
<p>
	After installing you may simply start brewing, by fermenting ingredients, distilling and aging the ingredients. Check the Wiki for detailled informations about the process of brewing.
</p>
<p>
	To also take advantage of the more advanced features, you may want to have a look at the config, where you can create your own recipes and even alter the word replacements in chat when a player is drunk. By default there are just some basic recipes, that show what settings you can utilize. There are plenty more possibilities to create own recipes such as Gin, Whiskey, etc. You may want to look around on the internet about how the Drinks are made, or create fantasy recipes with funny effects and ingredients.
</p>
<p>
Most of the good Drinks should be kept secret or have just vague descriptions on how to brew them. That allows players to try around on specific ingredients, so that only certain brewers master the creation of a high quality drinks.
</p>
<p>
When it comes to drinking, it is nice to define Wakeup Points. These are places in the World where players "wake up" when they log off for a period of time while drunk. These places may be anything like high on a tree, inside a cave, on towers, on small islands or in astonishing buildings.
</p>
<p>
For best results the places should be distributed over a big area, as the algorithm favors a place near the players current position.
</p>
<h2>Translations</h2>
<p>
By Default, the Plugin is in english language and config. It is highly advised to use the config and language file for your language, as some parts of the plugin (like the Chat distortion) are language specific.
</p>
<p>
Config and Language files are included with the Plugin and can be found in the Brewery folder after first run. Simply replace the generated config with one from the "configs" folder. Which language file to use is set in the config.
</p>
<p>
Language files are to be placed in the folder: plugins/brewery/languages/
</p>
<ul>
	<li>German and English language file and config by DieReicheErethons</li>
	<li>French language file and config, thanks to AzuraStars, citron09 & XTREM5000</li>
	<li>Italian language file and config, thanks to FraazT0</li>
</ul>
<h2>Important Commands</h2>

| Command | Description | 
| ------------- | ------------- |
| /br help | Shows the help page | 
| /br info | Information about your own drunkeness | 
| /br info <player | Information about the drunkeness of <player> | 
<h2>Important Permissions</h2>

| Permission | Description | 
| ------------- | ------------- |
| brewery.user | Access to everything needed for brewing (default)| 
| brewery.mod | Allow to maintain Wakeup Points and to login even if overdrunken| 
| brewery.admin | Give access to every Command and most bypasses (Default: op)| 

<p>
<!--A complete list of commands and permissions can be found here-->
</p>
<p>
This Plugin now uses bStats! This submits anonymous stats about your server (player count, plugin/server version, etc.) to the public statistic website bStats.org which will provide developers with usage statistics of this plugin. If you don't want this feature and wish to opt-out, you can do so in the /plugins/PluginMetrics/config.yml
</p>
<p>
This Plugin uses an automatic Update Checker. It Checks the CurseForge api for updates to this Plugin at each serverstart. If an Update is found, the Log and Ops are notified. The Update Checker runs in a seperate async thread, so it can never lock-up the Server. If you wish, you can turn the Update Checker off in the config.yml
</p>
