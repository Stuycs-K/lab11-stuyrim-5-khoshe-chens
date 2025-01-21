[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features





:question: When all enemies or allies die, win/lose screen is displayed (extra)

:ballot_box_with_check: Asking for target based on name

:ballot_box_with_check: adventurer names are randomly chosen from a list with no repeats

:ballot_box_with_check: added baseDmg to all Adventurer subclasses so an Adventurer's damage can be buffed

:question: if HP goes below 0, the character dies and can no longer attack or get attacked  (required)

:question: program ends when player quits or all characters on a team is defeated (required)

:question: player is able to choose 1-3 opponents (required)

:question: when only one opponent is chosen, it is the boss (required)

:white_check_mark: Necromancer attack/support/special

:white_check_mark: Priest attack/support/special

:white_check_mark: Boss attack/support/special

:white_check_mark: Displaying player attacks in left box and enemy attacks on right box

:white_check_mark: Enemies' Turn, press enter to see each move

:white_check_mark: Party's Turn, displays correctly, all damage is truncated to nearest integer

:white_check_mark: drawBackground, drawText, TextBox, colorByPercent, createRandomAdventurer, userInput, quit

:white_check_mark: every adventurer's name, type, HP, and special are displayed properly inside border

:white_check_mark: drawScreen, text displays and clears correctly

:white_check_mark: HP never goes below 0

:white_check_mark: HP never goes above maxHP 

:question: run (missing special case for priest special attack when player's turn) (required)


pls delete this part when the checklist is completely updated
:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses

|**Adventurer Subclasses**|**Necromancer**|**Priest**|**Dark Lord (Boss)**|
| --- | --- | --- | --- |
|**Max HP**| 15 | 20 | 40 |
|**Attack**| Staff Drain: deals damage worth 10~20% of target's health|Holy Light: deals 1~3 damage to target | Corrupting Touch: deals 5~7 damage to target |
|**Support**| Summon Skeletons: buffs target's damage by 3| Healing Spell: heals target by 5 hp| Void Sacrifice: sacrifices 5 hp of its own for 7 void essence|
|**Special**| Death's Touch: sets target's health to 0.7 of what it originally was| Divine Grace: heals their own team by 3 hp and buffs everyone's damage by 2| Black Hole: takes away 50% of target's health|
