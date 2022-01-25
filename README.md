# name rule
This is for someone who has naming trouble.

:warning: Please follow the below naming rule. :warning:

## variable name

if you're naming a variable which motor or a object which is actually exists :
> o_[ usage(usually is the name of the file) ]_{ direction }[ motor controller type ( define it with below table ) ]{ motorname }

ex : `o_drive_LeftFrontVictorCIM`

| Motor controller type | Motor name | fireware company |
| --------------------- | ---------- | ---------------- |
| VictorSPX | brushed | CTRE |
| TaloxFX | Falcon 500 | CTRE |
| SparkMax | brushed / Neo / Neo 550 | REV Robotics |
| Spark | brushed | REV Robotics |

> Brushed: PG motor, CIM, 775 Red Line, Gearmotor, Snow Blower Motor, Bosch Seat Motor <br>
> Brushless: Neo, Neo 550, Falcon 500

Table unfinished......
