<div align="center">
  <kbd> <img src="https://github.com/Jackson-Wozniak/SimCombat-MMA-League/assets/105665813/c322cf43-0511-45f6-b77f-b9689cce0eb6" width="665" height="389"/> </kbd>
  
  <h3 align="center">SimCombat MMA League</h3>

  <a href="https://github.com/Jackson-Wozniak/SimCombat-MMA-League/blob/documentation"><strong>Simulations & Features»</strong></a>
    </br>
    <p>
      <img src="https://img.shields.io/github/commit-activity/m/Jackson-Wozniak/SimCombat-MMA-League" alt="commits" />
      <img src="https://img.shields.io/github/issues/Jackson-Wozniak/SimCombat-MMA-League" alt="issues" />
      <img src="https://img.shields.io/github/license/Jackson-Wozniak/SimCombat-MMA-League" alt="license" />
    </p> 
    <a href="https://github.com/Jackson-Wozniak/SimCombat-MMA-League/Contributions.MD">Contribute</a>
    ·
    <a href="https://github.com/Jackson-Wozniak/SimCombat-MMA-League/issues">Report Bug</a>
    ·
    <a href="https://github.com/Jackson-Wozniak/SimCombat-MMA-League/issues">Request Feature</a>
</div>

## :books: Table of Contents

<ol>
    <li><a href="#features">Features</a></li>
    <li><a href="#league">MMA League Overview</a></li>
    <li><a href="#statistics">Fight Results & Statistical Model</a></li>
    <li><a href="#local-dev">Local Deployment</a></li>
</ol>    

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## 📓 Features & Overview <a id="features"></a>

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## :file_folder: SimCombat League Overview <a id="league"></a>

MMA League Overview (subject to change, has not been implemented as of this writing)
- 8 weight classes, each with 12 ranked fighters and up to a total of 20 non-ranked fighters
- Events are held weekly. Events have 10 fights, with a main and co main event
  - 4 fights per event involve at least 1 ranked fighter
  - Fights are simulated, this program exists solely through an API that updates automatically
  - Rankings are updated post event
  - Time starts based on the date the program is first run, but doesn't match real time
  - Events are held every 1-hour real time, equal to 1 week (each Saturday) in game
  - Event names start at 1 and follow from there ({League Name} 2, {League Name} 3...)
  - Fights are scheduled 4 weeks in advance, so a 4-week schedule always exists
  - Fights are chosen based on ELO within a weight class
  - Fighters cannot have more than one scheduled bouts at a time. No injuries/backups occur in this simulation
- Fighters
  - Alongside rankings, fighters have an ELO score that allows for non-ranked fighters to fight those with ranks
  - This ELO is what decides the ranking behind the scenes
  - Each fighter has stats & attributes (details will be given later for these things)
  - Each fighter has a legacy score within their stats, so a leaderboard of the GOAT can be made
  - Legacy score will be updated with each fight. The primary way to receive this is to become champ and defend the belt
  - Fighters retire, which allows for an opening in the weight class
  - Fighters that dip below an ELO value will be kicked out, also allowing for opening in weight class
- Fighter Details
  - Each fighter has name, weight & age (birthday)
  - TO BE DETERMINED: may add some type of fan tracker that determines how popular fighters are
  - Stats
    - Fighter records are updated after each bout
    - ELO is updated after each bout
    - Rankings are not directly saved. Instead, the weight classes sort the fighters by ELO to determine rank
    - Fighter champion rank is kept as enum. Determines event order priority & legacy score changes. Values: Champion, Past Champion, Ranked, Non-Ranked
    - Legacy Score
      - Legacy score determines the historical order of fighters. Those that retire are added to hall of fame if legacy score is high enough after retirement 
      - Those with a high enough legacy score are still allowed in hall of fame even if they are kicked out of weight class due to low ELO 
      - Legacy score changes are determined by the fighter champion rank, type of win etc.
    - Knockout, submission, decision wins/losses are tracked
  - Attributes
    - Fighters have a discipline (fighting style). Values: mixed martial artist, jiu jitsu, wrestling, kickboxing
    - Discipline level determine how successful they are with whatever style they have
    - Alongside discipline level, fighters have a general grade (0-100) that determines there overall ability
    - Fighters with higher discipline level & grades will have a higher chance of success
    - Longevity score is updated after each fight. Cannot go back up & once it hits 0 the fighter retires. Types of wins/losses affect the rate that this changes after a fight
    - Exact statistical model relating grade/level to performance is yet to be determined
    - Fighter longevity slightly affects the grade of the fighter, but not by a wide margin
    - Rather, aging fighters lose grade points faster, but often keep discipline level
    - Aging fighters also lose longevity at a faster rate than their younger counterparts. Age is based on in game time (their birthday is all that is directly associated with the fighter, age is calculated from that)
    - TO BE DETERMINED: may add some type of "motivation" score that affects the rate that grade changes
    - TO BE DETERMINED: not sure how grade will change as of right now, but will be based partially off fight results



# Class Blueprint

### WeightClass (CLASS)
##### Attributes
weight: int (ID)
List<Fighter> fighters - A list of up 12 to 32 fighters (12 ranked, up to 20 unranked). Sort by ELO to determine rankings in each weight class
##### Interactions with other classes
- Holds list of pointers to fighters in database
- Aggregates & sorts fighters of the same class when generating matches
##### Related API Endpoints


### Event (CLASS)
##### Attributes
name: String (ID)
date: LocalDateTime
List<Fight> fights - 10 fights (at least 4 involve at 1 or more ranked fighter)
##### Interactions with other classes
##### Related API endpoints

### PastEvent (CLASS)
##### Attributes
name: String (ID)
date: LocalDateTime
List<PastFight> fights - all fights from the event with the result & fighter names
##### Interactions with other classes
- Generated from Event class once event is processed and completed
- Separate entity in database
##### Related API endpoints
- getAllPastEvents()
- getPastEvent(name)
- getPastEvent(date)
- getPastEvents(startDate, endDate)

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## :bar_chart: Fight Results & Statistical Model <a id="statistics"></a>

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## :electric_plug: Local Deployment <a id="local-dev"></a>

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->
