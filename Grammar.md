## Action
The building block of descript is the **action**. Every values the mod can use are actions, even fps and bps (blocks per second)
`$attack` return the value, so
```
{$attack} CPS
```
Return "? CPS"

But we can modify its return value using `:`

`true` means pressed
`false` means unpressed

```
{$attack:
    true=[text:"key is pressed"; textColor:"ffffff"; backgroundColor:"ffffff"];
    false=[text:"key is not pressed"; textColor:"ffff00"; backgroundColor:"ff00ff"]
}
```
