def update () : Unit = {
    playr.setPosition(playr_x, -50)
    stair.setPosition(stair_x, -80)
    bonus.setPosition(bonus_x, bonus_y)
}
def restart () : Unit = {
    stair_x = random(-200, 200)
    bonus_x = random(-200, 200)
    bonus_y = -10
    update()
}
clear
cleari
var fon = Picture.image("fon.png")
fon.draw()
fon.scale(1.3)
fon.setPosition(-430, -450)
var floar = Picture.image("floar.png")
floar.draw()
floar.scale(10)
floar.setPosition(-450, -100)
var stair_x = random(-200, 200)
var stair = Picture.image("stair.png")
stair.draw()
stair.scale(10)
stair.setPosition(stair_x, -80)
var bonus_x = random(-200, 200)
var bonus_y = -10
var bonus = Picture.image("bonus.png")
bonus.draw()
bonus.setPosition(bonus_x, bonus_y)
bonus.scale(5)
var playr_x = random(-200, 200)
var playr = Picture.image("playr.png")
playr.draw()
playr.scale(5)
playr.setPosition(playr_x, -50)
while (playr_x == bonus_x) {
    bonus_x = random(-200, 200)
}
var point = 0
var level = 1
println("| level : "+level + " | point : "+point+" |")
animate {
    onKeyPress {
    case Kc.VK_A =>
        playr_x -= 25
    case Kc.VK_D =>
        playr_x += 25
    case Kc.VK_R =>
        println("==-- --==")
        restart()
        point = 0
        level = 1
        println("| level : "+level + " | point : "+point+" |")
    case Kc.VK_SPACE =>
        if (playr.intersects(stair)) {
            bonus_y = -10
            point += 1
            level += 1
            println("   level : "+level)
            println("point : "+point)
            restart()
        }
    }
    update()
    if (playr.intersects(bonus)) {
        point += 1
        println("point : "+point)
        bonus_y = 1000
    }
}
