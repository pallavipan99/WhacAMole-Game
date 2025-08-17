# Whac‑A‑Duck (Whac‑A‑Mole) — Android Game

A fast‑paced Android tap game inspired by **Whac‑A‑Mole**. Ducks pop up at random spots; tap them to score before they disappear. Some ducks are **bonus ducks** that grant extra time. Built in **Java** using `AppCompatActivity`, **ConstraintLayout**, and lightweight **animations** — no external libraries required.

---

## Key Features

- **9‑spot grid gameplay** using `ImageView`s in a `ConstraintLayout`.
- **Random spawns** with per‑spawn animations (scale + fade).
- **Bonus ducks** add **+5 seconds** to the countdown when hit.
- **Single‑tap scoring** per duck appearance (prevents double counting).
- **Visible timer & score HUD** (`TextView`s).
- Clean, self‑contained logic inside `MainActivity`.

> The supplied code names the package `com.example.whacaduck`, but the game is conceptually Whac‑A‑Mole.

---

## Tech Stack

| Area      | Tech |
|-----------|------|
| Language  | Java (Android) |
| UI        | ConstraintLayout, ImageView, TextView, Button (optional) |
| Effects   | `ScaleAnimation`, `AlphaAnimation`, `AnimationSet` |
| Min/Target SDK | Use your project defaults (works on modern Android Studio templates) |

No internet, GPS, or storage permissions are required.

---

## Project Structure (typical)

```
app/
  src/main/java/com/example/whacaduck/
    MainActivity.java            # Game loop, UI wiring, animations, scoring
  src/main/res/layout/
    activity_main.xml            # 3x3 ImageView grid + HUD (timer, score)
  src/main/res/drawable/
    duck.png                     # Normal duck/mole
    bonusduck.png                # Bonus variant (+5s when tapped)
    countduck.png                # HUD icon (score)
  AndroidManifest.xml
  build.gradle
```

> Your drawable names must match the code: `duck`, `bonusduck`, and `countduck` (PNG/WebP recommended). The layout should contain **9** `ImageView`s (e.g., `imageView1 … imageView9`), and two `TextView`s for **timer** and **score**.

---

## How the Game Works (Overview)

- The activity creates references to 9 `ImageView`s (`duck … duck9`) and two `TextView`s (`timer`, `num` for score).
- On each tick in the loop:
  - One (or more) random `ImageView`s are set **VISIBLE**.
  - With a small probability, the shown duck becomes a **bonus duck** by setting its image and `Tag` to `R.drawable.bonusduck`.
  - Appearing ducks run an **AnimationSet** (scale up/down + fade).
  - Each visible duck gets a **one‑time** click listener:
    - **+1** to score.
    - **+5 sec** to the remaining time **if** it was a bonus duck.
    - The one‑time guard (`countX`) prevents multiple increments from repeated taps while visible.
- The game starts at **60 seconds** and counts down to **0**. UI updates show **timer** and **score** continuously.

> The code uses `setImageResource`, `setTag`, visibility toggles, and per‑view listeners rather than a central SurfaceView — simple and easy to follow.

---

## Run It (Android Studio)

1. **Open** the project in **Android Studio (Giraffe+ recommended)**.
2. Make sure your `activity_main.xml` has:
   - 9 `ImageView`s arranged in a 3×3 layout (ConstraintLayout is fine).
   - `TextView` for **Timer** and **Score** (IDs should match those in `MainActivity`).
3. Put the images in `app/src/main/res/drawable/` with names:
   - `duck.png`, `bonusduck.png`, `countduck.png`.
4. **Build & Run** on an emulator or a physical device.

No additional Gradle dependencies are required beyond the standard Android app template.

---

## Controls & Scoring

- **Tap** any visible duck to gain **+1** point.
- If the duck was **bonus** (special image/tag), you also get **+5 seconds**.
- You can only score **once** per visible duck instance (guarded by local counters).

---

## Customization Tips

- **Spawn rate** & **visibility duration**: tune the random timing or animation durations.
- **Difficulty**: increase simultaneous spawns or reduce visibility time.
- **Assets**: replace the 3 drawable assets with your own sprites.
- **Audio**: add a `SoundPool` to play hit/miss effects (optional).
- **End screen**: show a dialog/fragment when `second == 0` to display final score.

---

## Known Limitations

- The current approach uses per‑view listeners and animations; if you want high‑FPS or physics‑like behavior, consider a `SurfaceView`/`Canvas` game loop.
- Make sure to **clear animations** and listeners in lifecycle methods if you add pausing/resuming.


