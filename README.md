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

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## :bar_chart: Fight Results & Statistical Model <a id="statistics"></a>

- Fight results are calculated per round
- Variables to account for (f1 is fighter 1, f2 is fighter 2), named different in program
  - x1, x2 -> KO chance for f1 & f2
  - y1, y2 -> SUB chance for f1 & f2
  - z1, z2 -> round win chance for f1 & f2
- 100% = (x1 + x2) + (y1 + y2) + (z1 + z2)
- w is a random num 1 - 100 | the value of w determines the result of the round. It can be thought of on a number line 1-100
- EXAMPLE: 50/50 chance for either fighter to win (x1 + y1 + z1 = 50%)
  - x1 = 2%, x2 = 4%
  - y1 = 4%, y2 = 5%
  - z1 = 44%, z2 = 41%
  - number line for w -> x1 = [1, 2] | x2 = [3, 6] | y1 = [7, 10] | y2 = [11, 15] | z1 = [16, 59] | z2 = [60, 100]
  - if w = 16 for R1, f1 wins R1 because it falls in the range of z1
  - if w = 1 for R2, f1 wins by R2 KO because w falls in range of x1
- Example 25/75 chance of win favoring f2 (x2 + y2 + z2 = 75%)
  - x1 = 5%, x2 = 10%
  - y1 = 5%, y2 = 10%
  - z1 = 15%, z2 = 55%
  - number line for w -> x1 = [1, 5] | x2 = [6, 15] | y1 = [16, 20] | y2 = [21, 30] | z1 = [31, 45] | z2 = [46, 100]
  - if w = 49 for R1, f2 up 10-9
  - if w = 35 for R2, tied 19-19
  - if w = 65 for R3, f2 wins by 29-28 decision

These variables & win chance are decided by the FighterAbility class
Base KO, SUB rates +/- ability weight for each fighter
Win chance is 50/50 base, and then weighted depending on the total ability of fighter

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->

## :electric_plug: Local Deployment <a id="local-dev"></a>

<br/> 
<!-- -------------------------------------------------------------------------------------------------------------------------------------------- -->
