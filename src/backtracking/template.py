def backtrack(state):
    if is_solution(state):
        results.append(state.copy())
        return

    for choice in get_choices(state):
        if is_valid(choice, state):
            make_choice(choice, state)
            backtrack(state)
            undo_choice(choice, state)
