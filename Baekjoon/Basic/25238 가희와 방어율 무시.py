monster_defense, ignore_defense = map(int,input().split())
if monster_defense - (monster_defense * (ignore_defense/100)) >= 100:
    print(0)
else:
    print(1)