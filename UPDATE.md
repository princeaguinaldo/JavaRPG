# 🎮 Java RPG - Game Update v2.0

## 📝 Overview
The Java RPG has been significantly expanded with advanced features including a full progression system, equipment management, strategic combat mechanics, and a dynamic shop system.

## ✨ New Features Added

### 1. **Player Class System**
- Persistent player statistics and inventory
- Character-based progression instead of primitive data types
- Full character status display

### 2. **Experience & Leveling System**
- Gain experience points (XP) from defeating enemies
- Level up progressively to increase stats:
  - Max health increases by 20 per level
  - Weapon power increases by 3 per level
  - Armor defense increases by 1 per level
- Dynamic XP requirement (increases with each level)
- Visual level-up notifications

### 3. **Equipment System**
- **Weapons:**
  - Wooden Sword (starting weapon, +5 damage)
  - Iron Sword (50 gold, +10 damage)
  - Battle Axe (100 gold, +15 damage)

- **Armor:**
  - Leather Armor (starting, +2 defense)
  - Steel Armor (30 gold, +4 defense)
  - Heavy Plate Armor (75 gold, +7 defense)

### 4. **Multiple Enemy Types**
- **Goblin** - Easy (20 HP, 8 damage, 30 XP)
- **Orc** - Medium (40 HP, 15 damage, 60 XP)
- **Troll** - Hard (60 HP, 20 damage, 100 XP)
- **Dragon** - Boss (100 HP, 30 damage, 200 XP)
  - Appears after reaching level 5 with 30% encounter rate

### 5. **Strategic Combat System**
Players can now choose their action each turn:
- **Attack** - Deal weapon damage + random bonus
- **Defend** - Reduce incoming damage by 10 points
- **Use Potion** - Restore 40 HP during battle

### 6. **Shop System**
- Purchase weapons to increase damage output
- Buy armor to increase defense
- Stock up on potions
- Dynamic pricing and inventory

### 7. **Rest/Inn System**
- Pay 10 gold to fully restore health at inns
- Strategic resource management between battles

### 8. **Multiple Locations**
- Dark Forest
- Mountain Pass
- Ancient Ruins
- Dragon's Lair (unlocked at higher levels)

### 9. **Enhanced UI**
- Formatted menus with clear options
- Detailed character status screen
- Battle progression display
- Gold and resource tracking

## 🎯 Game Flow
```
1. Create character with a name
2. Start in the main menu
3. Choose to Explore, View Status, Use Potion, Visit Shop, Rest, or Exit
4. Encounter random enemies in different locations
5. Engage in strategic combat with multiple action choices
6. Earn gold and experience from victories
7. Level up to become stronger
8. Purchase better equipment from the shop
9. Progress until you reach higher levels or are defeated
```

## 🛠 Technical Improvements

### Object-Oriented Design
- **Player Class**: Encapsulates all player data and methods
- **Enemy Class**: Handles enemy creation and management
- **Methods**: Specialized functions for battles, shopping, and progression

### Code Organization
- Cleaner separation of concerns
- Reusable Player and Enemy classes
- Dynamic scaling of game difficulty

### Game Mechanics
- Armor reduces enemy damage before applying to player
- Weapon power scales with player progression
- Experience and leveling curve becomes progressively harder
- Dynamic enemy selection based on player level

## ▶ How to Compile & Run

```bash
# Navigate to project directory
cd "JavaRPG"

# Compile
javac -d bin src/App.java

# Run
java -cp bin App
```

## 📊 Progression Example
- **Level 1**: 100 HP, 5 weapon damage, 2 armor defense | Need 100 XP for level 2
- **Level 2**: 120 HP, 8 weapon damage, 3 armor defense | Need 150 XP for level 3
- **Level 5**: 180 HP, 17 weapon damage, 6 armor defense | Dragons start appearing
- **Level 10**: 280 HP, 32 weapon damage, 11 armor defense | Endgame content

## 💰 Economy System
- **Starting Gold**: 50
- **Shop Costs**:
  - Potion: 20 gold
  - Leather Armor: 30 gold
  - Sword: 50 gold
  - Battle Axe: 100 gold
  - Steel Armor: 75 gold
- **Inn Rest**: 10 gold
- **Enemy Rewards**:
  - Goblin: 15 gold
  - Orc: 30 gold
  - Troll: 50 gold
  - Dragon: 100 gold

## 🎮 Strategy Tips
- Buy weapons early to deal more damage
- Use the Defend action when health is low
- Stock up on potions before boss encounters
- Visit the inn when health drops below 30%
- Focus on leveling up for better stats
- Equip better armor as you progress

## 📚 Technologies Used
- Java 8+
- Object-Oriented Programming (OOP)
- Encapsulation and Class Design
- Random number generation
- Scanner for user input
- Switch statements for menu navigation

## 🔮 Future Enhancement Ideas
- Quests and missions
- NPCs and dialogue systems
- Magic spells and abilities
- Special items and relics
- Skill trees
- Save/Load game functionality
- Leaderboard system
- Multiple character classes (Warrior, Mage, Rogue)
- Inventory weight management
- Enemy drop rates for rare items

---
**Version**: 2.0  
**Last Updated**: February 2026  
**Status**: Fully functional with expanded features
