package jp.ac.uryukyu.ie.e165735;

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * @param name 生物名
     * @param maximumHP 生物のHP
     * @param attack 生物の攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * @return boolean  生死状態、trueだと死んでいる
     */
    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }


    /**
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(dead == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            if (name == "Hero") {
                System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
            } else {
                System.out.printf("モンスター%sは倒れた。\n", name);
            }
        }
    }
}
