[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features



:question: if HP goes below 0, the player dies

:question: When all enemies or allies die, win/lose screen is displayed

:question: boss has a 30% of showing up as an enemy

:ballot_box_with_check: Asking for target based on name

:ballot_box_with_check: adventurer names are randomly chosen from a list with no repeats

:ballot_box_with_check: added baseDmg to all Adventurer subclasses so an Adventurer's damage can be buffed

:white_check_mark: Necromancer attack/support/special

:white_check_mark: Priest attack/support/special

:white_check_mark: Displaying player attacks in left box and enemy attacks on right box

:white_check_mark: Enemies' Turn, press enter to see each move

:white_check_mark: Party's Turn, displays correctly, all damage is truncated to nearest integer

:white_check_mark: drawBackground, drawText, TextBox, colorByPercent, createRandomAdventurer, userInput, quit

:white_check_mark: every adventurer's name, type, HP, and special are displayed properly

:white_check_mark: drawScreen, text displays and clears correctly

:white_check_mark: HP never goes below 0

:question: HP never goes above maxHP

:question: run (missing special case for priest special attack when player's turn)


pls delete this part when the checklist is completely updated
:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses

|**Adventurer Subclasses**|**Necromancer**|**Priest**|**blank(Boss)**|
| --- | --- | --- | --- |
|**Max HP**| 15 | 20 | 40 |
|**Attack**| Staff drain: deals damage worth 10~20% of target's health|Holy Light: deals 1~3 damage to target | not set yet |
|**Support**| Summons skeletons: buffs target's damage by 3| Healing spell: heals target by 5 hp| tbd|
|**Special**| Death's Touch: sets target's health to 0.3 of what it originally was| Divine Grace: heals their own team by 3 hp and buffs everyone's damage by 2| tbd|
