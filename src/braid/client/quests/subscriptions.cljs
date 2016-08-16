(ns braid.client.quests.subscriptions
  (:require [reagent.ratom :include-macros true :refer-macros [reaction]]
            [braid.client.state.subscription :refer [subscription]]))

(defmethod subscription :quest-completed?
  [state [_ quest-id]]
  (reaction (contains? (get-in @state [:user :completed-quest-ids]) quest-id)))

(defmethod subscription :completed-quest-count
  [state _]
  (reaction (count (get-in @state [:user :completed-quest-ids]))))
