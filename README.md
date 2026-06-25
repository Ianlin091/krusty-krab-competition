# 🍔 蟹堡王大賽：設計模式整合專案 (Krusty Krab Competition)

這是一個以 **Java Swing** 實作的雙人反應速度小遊戲——**「蟹堡王大賽」**。
本專案為物件導向設計模式的綜合實作，精巧地融合了 **6 種經典設計模式**。

---

## 🎮 遊戲玩法與規則

在遊戲中，海綿寶寶與派大星將展開一場 30 秒的做蟹堡速度大決鬥！

### 鍵盤操控說明

| 角色 | 動作類型 | 按鍵 | 觸發條件 |
| :--- | :--- | :---: | :--- |
| **海綿寶寶 (左)** | 普通動作 | **`S`** | 隨時可按 |
| **海綿寶寶 (左)** | 高級動作 | **`D`** | 左方牌子亮起「**普通高級亮**」時 |
| **派大星 (右)** | 普通動作 | **`K`** | 隨時可按 |
| **派大星 (右)** | 高級動作 | **`L`** | 右方牌子亮起「**普通高級亮**」時 |

### 遊戲流程

1. **準備階段**：點擊公佈欄進入遊戲。
2. **更衣室 (換裝)**：為海綿寶寶和派大星挑選不同的帽子裝扮，支援 **Undo / Redo (撤銷/重做)**。
3. **選擇背景**：使用左右鍵循環瀏覽並挑選比賽的背景關卡。
4. **倒數開始**：3、2、1，Go！
5. **遊戲進行**：畫面上方會隨機顯示提示牌（普通亮、普通高級亮），玩家必須快速按下對應按鍵，率先得到最高分！
6. **結算畫面**：限時 30 秒結束，判定獲勝者（Win、Lose 或 Tie）。
7. **確認重玩**：在結算贏家畫面上**點擊任意處**，會彈出確認對話框詢問是否重新開始。若選擇「是」，則會自動關閉舊視窗並重新啟動遊戲，讓你重新搭配角色與挑選場地！

---

## 🛠️ 設計模式架構解析

本專案實作了以下 6 種設計模式，使整體架構更具彈性、高內聚且低耦合：

```mermaid
graph TD
    subgraph State Pattern
        SC[StateContext] -->|執行狀態| AbsS[AbsState]
        AbsS <|-- StatePrestart
        AbsS <|-- StateStart
        AbsS <|-- StateEnd
    end

    subgraph Command Pattern
        MC[MacroCommand] -->|記錄與復原| Cmd[Command]
        Cmd <|-- SbChangeHat1
        Cmd <|-- SbChangeHat2
        Cmd <|-- PtChangeHat1
        Cmd <|-- PtChangeHat2
        Cmd -->|控制接收者| Rec[Receiver]
    end

    subgraph Decorator Pattern
        Comp[Component] <|-- ConcreteSb
        Comp <|-- ConcretePt
        Comp <|-- Decorator
        Decorator <|-- CD_SbH1
        Decorator <|-- CD_PtH1
    end

    subgraph Iterator Pattern
        Ag[Aggregate] -->|取得迭代器| It[Iterator]
        ConcreteAg[ConcreteAggregate] -.->|實作| Ag
        ConcreteIt[ConcreteIterator] -.->|實作| It
    end

    subgraph Strategy Pattern
        StratC[StrategyContext] -->|執行按鍵策略| SbStrat[SbKeyStrategy]
        StratC -->|執行按鍵策略| PtStrat[PtKeyStrategy]
    end

    subgraph Flyweight & Observer
        FWF[FlyweightFactory] -->|共用 Label| FWL[FlyweightLabel]
        Subj[ConcreteSubject] -->|通知分數變更| Obs[Observer]
        Obs <|-- SbScoreLabel
        Obs <|-- PtScoreLabel
    end
```

### 1. State Pattern (狀態模式)
* **相關類別**：`state.StateContext`, `state.AbsState`, `state.StatePrestart`, `state.StateStart`, `state.StateEnd`
* **應用細節**：管理遊戲的生命週期與視窗狀態切換。當遊戲時間歸零，`StateStart` 就會透過 `StateContext` 切換到 `StateEnd`，讓不同的狀態物件自行決定如何渲染視窗與重置資源。

### 2. Strategy Pattern (策略模式)
* **相關類別**：`strategy.StrategyContext`, `strategy.SbKeyStrategy`, `strategy.PtKeyStrategy`, `strategy.StrategySbord`, `strategy.StrategySbup`, `strategy.StrategyPtord`, `strategy.StrategyPtup`
* **應用細節**：將玩家按下「普通按鍵」或「高級按鍵」時的計分與圖片切換邏輯封裝在不同的策略類別中，便於未來隨時擴充新的操控行為。

### 3. Decorator Pattern (裝飾者模式)
* **相關類別**：`decorator.Component`, `decorator.Decorator`, `decorator.ConcreteSb`, `decorator.ConcretePt`, `decorator.CD_SbH1`, `decorator.CD_SbH2`, `decorator.CD_PtH1`, `decorator.CD_PtH2`
* **應用細節**：用於動態改變角色的帽子外觀。透過包裝 `Component`，動態組合出角色的外觀路徑（例如戴上草帽或高帽），而不需要為每一種帽子組合建立大量的子類別。

### 4. Command Pattern (命令模式)
* **相關類別**：`command.Command`, `command.MacroCommand`, `command.Receiver`, `command.PtChangeHat1` / `2`, `command.SbChangeHat1` / `2`
* **應用細節**：用於更衣室中的換裝復原機制。每一次換裝都是一個 Command，由 `MacroCommand` 使用 List 結構記錄，進而實作出無痛的 Undo / Redo 按鈕功能。

### 5. Flyweight + Observer Pattern (享元與觀察者模式)
* **相關類別**：
  * **Flyweight**: `flyweight_observer.FlyweightFactory`, `flyweight_observer.FlyweightLabel`, `flyweight_observer.ConcreteFlyweightLabel`
  * **Observer**: `flyweight_observer.Observer`, `flyweight_observer.PtScoreLabel`, `flyweight_observer.SbScoreLabel`, `flyweight_observer.ConcreteSubject`
* **應用細節**：
  * **Flyweight**：將多個重覆使用的 ImageIcon 與 JLabel 緩存在 `FlyweightFactory` 中共享，避免記憶體開銷。
  * **Observer**：當遊戲中兩位角色的得分改變時，通知註冊的分數看板觀察者（`SbScoreLabel`, `PtScoreLabel`）自動重新繪製、更新畫面的分數。

### 6. Iterator Pattern (迭代器模式)
* **相關類別**：`iterator.Iterator`, `iterator.Aggregate`, `iterator.ConcreteIterator`, `iterator.ConcreteAggregate`
* **應用細節**：用於選關卡背景圖片。將背景圖片名稱封裝於 `ConcreteAggregate`，透過 `ConcreteIterator` 的 `next()` 與 `previous()` 來走訪，達到背景無縫輪播。

---

## 🚀 如何在本機執行

本專案所有的 Java 原始碼均已編譯為 `.class` 檔並放置於 `bin` 目錄。若您的電腦上已安裝 Java，可以直接執行以下指令啟動遊戲。

### 方法一：使用預先編譯的 `bin` 執行（推薦）

開啟終端機（cmd 或 PowerShell），切換至專案根目錄，然後執行：

```bash
# Windows 環境下使用本機 Java 執行
java -cp bin krusty_krab_competition.KrustyKrab_Controller
```

> 💡 **提示**：如果您的本機 `java` 尚未設定到環境變數中，可以直接呼叫您 IDE 的 JDK：
> ```powershell
> & "C:\Program Files\JetBrains\IntelliJ IDEA 2023.2.4\jbr\bin\java.exe" -cp bin krusty_krab_competition.KrustyKrab_Controller
> ```

### 方法二：重新編譯並執行

如果您對原始碼進行了修改，需要重新編譯：

```bash
# 建立/清理 bin 目錄後編譯
javac -d bin -encoding UTF-8 src/**/*.java

# 執行
java -cp bin krusty_krab_competition.KrustyKrab_Controller
```

---

## 👥 團隊合作說明

本專案為團隊合作開發。我在此專案中主要負責 **UI 介面開發、Swing 元件排版與流程整合**，核心邏輯與部分設計模式架構由其他組員共同協作完成。

